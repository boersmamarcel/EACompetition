public class child{
  private double[] xs;
  private double fitness_;

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
}