package evo;

public class Child{
  private double[] xs;
  private double fitness_;

  public Child(double[] xs){
    this.xs = xs; 
  }

  public void setFitness(double f){
    this.fitness_ = f;
  }

  public double getFitness(){
    return this.fitness_;
  }

  public double[] getCoordinates(){
    return this.xs;
  }
}