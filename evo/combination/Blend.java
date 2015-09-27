package evo.combination;
import evo.Child;
import evo.Population;
import java.util.Random;

public class Blend implements Combination{

  private double alpha = 0; //mixing factor

  public Blend(double a){
    this.alpha = a;
  }

  public Child[] combine(Population parents){
    double coordinates[] = {0,0,0,0,0,0,0,0,0,0};
    Child childeren[] = {new Child(coordinates), new Child(coordinates)};

    //we can access all the parents, i.e. parent 1,2,3 etc.
    
    double xs1[] = {0,0,0,0,0,0,0,0,0,0};
    double xs2[] = {0,0,0,0,0,0,0,0,0,0};
    for(int i = 0; i < 10; i++){

        //average value from both parents
        double val1 = parents.population_.get(0).getCoordinates()[i];//get value from parent 1
        double val2 = parents.population_.get(1).getCoordinates()[i];//get value from parent 1
         
        double val = this.alpha*val1 + (1-this.alpha)*val2;
        double vall = this.alpha*val2 + (1-this.alpha)*val1;

        xs1[i] = val;
        xs2[i] = vall;
    
    }

    childeren[0] = new Child(xs1);
    childeren[1] = new Child(xs2);

    return(childeren); 
  }
}