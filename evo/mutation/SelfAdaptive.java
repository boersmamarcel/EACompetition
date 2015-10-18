package evo.mutation;

import java.util.Random;
import evo.Child;

public class SelfAdaptive implements Mutation{
 private double scale = 1;

  public SelfAdaptive(double scale){
    this.scale = scale;
  }

  private double randomGauss(double mu, double sigma){
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
    return (z*sigma + mu);
  }

  public Child mutate(Child aChild){


    double sigma[] = aChild.getSigma();
    double nsigma[] = {0,0,0,0,0,0,0,0,0,0};
 
    //get sigma
    for(int i = 0; i < 10; i++){ 
      nsigma[i] = sigma[i]*(Math.exp(-(aChild.generation/this.scale))) + this.randomGauss(0,sigma[i])*Math.exp(-(aChild.generation/this.scale));
    }

    //set sigma
    aChild.setSigma(nsigma);

    // System.out.printf("%n$%.2f",this.std);
    // System.out.println("SIGMA:"+this.scaledStd);

    double current[] = aChild.getCoordinates();
    //apply a gaussian mutation
    for(int i = 0; i < 10; i++){ 
      current[i] += nsigma[i]*this.randomGauss(0,1); //pertubate by gaussian noise
    }

    //update to new coordinates
    aChild.setCoordinates(current);
    return(aChild);
    }
}