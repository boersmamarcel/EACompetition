package evo;

public class child{
  private double[] xs;
  private double fitness_;
  private double minRange = -5;
  private double maxRange = 5;
  
  public child(double[] xs){
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

  @Override
  public String toString(){
    return(this.xs[0]+":"+this.xs[1]+":"+this.xs[2]+":"+this.xs[3]+":"+this.xs[4]+":"+this.xs[5]+":"+this.xs[6]+":"+this.xs[7]+":"+this.xs[8]+":"+this.xs[9]);
  }
}