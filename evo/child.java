package evo;

public class Child implements Comparable<Child>{
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