package evo.mutation;

import java.util.Random;
import evo.Child;

public class NonUniform implements Mutation{
  private double std = 0.0;
  public NonUniform(double std){
    this.std = std;
  }

// code from http://www.cs.princeton.edu/courses/archive/fall12/cos126/assignments/StdGaussian.java.html
  private double randomGauss(){
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
      return (z*this.std);
  }

public Child mutate(Child aChild){

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