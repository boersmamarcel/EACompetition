package evo.combination;
import evo.Child;
import evo.Population;
import java.util.Random;

public class Singlepoint implements Combination{

  private double alpha = 0; //mixing factor

  public Singlepoint(){
    this.alpha = 0.5;
  }

  public Child combine(Population parents){
    //we can access all the parents, i.e. parent 1,2,3 etc.
    Random rnd = new Random();
    //take a recombination point k (with k between 1-10)
    int idx = rnd.nextInt(10);
    //select first k elements from parent 1 and put them in the child
    double xs[] = {0,0,0,0,0,0,0,0,0,0};
    for(int i = 0; i < 10; i++){
      if(i <= idx){
        double val = parents.population_.get(0).getCoordinates()[i];//get value from parent 1
        xs[i] = val; //copy value from parent 1
      }else{
        //last (k,..,n) are the averages of both 
        //average value from both parents
        double val1 = parents.population_.get(0).getCoordinates()[i];//get value from parent 1
        double val2 = parents.population_.get(1).getCoordinates()[i];//get value from parent 1
        
        double val = this.alpha*val1 + (1-this.alpha)*val2;

        xs[i] = val;
      }
    }


    return(new Child(xs)); 
  }
}