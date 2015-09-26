package evo.combination;
import evo.Child;

public class Singlepoint implements Combination{
  public Child combine(Child child1, Child child2){
    double cxs[] = {Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()};
    return(new Child(cxs)); 
  }
}