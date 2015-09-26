package evo.combination;
import evo.Child;
import evo.Population;

public class Singlepoint implements Combination{
  public Child combine(Population parents){
    //we can access all the parents, i.e. parent 1,2,3 etc.
    double cxs[] = {Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()};
    return(new Child(cxs)); 
  }
}