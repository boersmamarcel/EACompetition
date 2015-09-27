package evo.combination;
import evo.Child;
import evo.Population;
import java.util.Random;

public class Simple implements Combination{

  private double alpha = 0; //mixing factor

  public Simple(double a){
    this.alpha = a;
  }

  public Child[] combine(Population parents){
    double coordinates[] = {0,0,0,0,0,0,0,0,0,0};
    Child childeren[] = {new Child(coordinates), new Child(coordinates)};

    //we can access all the parents, i.e. parent 1,2,3 etc.
    Random rnd = new Random();
    //take a recombination point k (with k between 1-10)
    int idx = rnd.nextInt(10);
    //select first k elements from parent 1 and put them in the child
    double xs1[] = {0,0,0,0,0,0,0,0,0,0};
    double xs2[] = {0,0,0,0,0,0,0,0,0,0};
    for(int i = 0; i < 10; i++){
      if(i <= idx){
        double val = parents.population_.get(0).getCoordinates()[i];//get value from parent 1
        double val1 = parents.population_.get(1).getCoordinates()[i]; //get value from parent 2
        xs1[i] = val; //copy value from parent 1
        xs2[i] = val1; //copy value from parent 2
      }else{
        //last (k,..,n) are the averages of both 
        //average value from both parents
        double val1 = parents.population_.get(0).getCoordinates()[i];//get value from parent 1
        double val2 = parents.population_.get(1).getCoordinates()[i];//get value from parent 1
        
        double val = this.alpha*val1 + (1-this.alpha)*val2;
        double vall = this.alpha*val2 + (1-this.alpha)*val1;


        xs1[i] = val;
        xs2[i] = vall;
      }
    }

    childeren[0] = new Child(xs1);
    childeren[1] = new Child(xs2);

    return(childeren); 
  }
}