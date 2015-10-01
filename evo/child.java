package evo;

public class Child implements Comparable<Child>{
  private double[] xs;
  private double fitness_;

  public double minRange = -5;
  public double maxRange = 5;

  public int generation = 1;

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

  public void setCoordinates(double[] xs){
    this.xs = xs;
  }
  @Override
  public String toString(){
    return(this.xs[0]+":"+this.xs[1]+":"+this.xs[2]+":"+this.xs[3]+":"+this.xs[4]+":"+this.xs[5]+":"+this.xs[6]+":"+this.xs[7]+":"+this.xs[8]+":"+this.xs[9]);
  }
  
  @Override
  public int compareTo(Child aChild) {
      if(aChild.getFitness() > this.getFitness()){
        return -1;
      }else if(aChild.getFitness() == this.getFitness()){
        return 0;
      }else{
        return 1;
      }
  }
}