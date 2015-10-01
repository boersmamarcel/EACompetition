package evo.mutation;

import java.util.Random;
import evo.Child;

public class SelfAdaptive implements Mutation{
 private double std = 0.0;
 private double scaledStd  = 0.0;
 private double scaling = 0.0;

  public SelfAdaptive(double std, double scaling){
    this.std = std;
    this.scaling = scaling;
  }

  private double randomGauss(){
    // code from http://www.cs.princeton.edu/courses/archive/fall12/cos126/assignments/StdGaussian.java.html
    double r, x, y;

    // find a uniform random point (x, y) inside unit circle
    do {
       x = 2.0 * Math.random() - 1.0;
       y = 2.0 * Math.random() - 1.0;
       r = x*x + y*y;
    } while (r > 1 || r == 0);    // loop executed 4 / pi = 1.273.. times on average
                                  // http://en.wikipedia.org/wiki/Box-Muller_transform

    // apply the Box-Muller formula to get standard Gaussian z    
    double z = x * Math.sqrt(-2.0 * Math.log(r) / r);

    //transformation see https://en.wikipedia.org/wiki/Box–Muller_transform#Implementation
    return (z*this.scaledStd);
  }

  public Child mutate(Child aChild){

    //set sigma
    this.scaledStd = this.std*(Math.exp(-(aChild.generation/this.scaling)));

    // System.out.printf("%n$%.2f",this.std);
    // System.out.println("SIGMA:"+this.scaledStd);

    double current[] = aChild.getCoordinates();
    //apply a gaussian mutation
    for(int i = 0; i < 10; i++){ 
      current[i] += this.randomGauss(); //pertubate by gaussian noise
    }

    //update to new coordinates
    aChild.setCoordinates(current);
    return(aChild);
    }
}