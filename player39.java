import org.vu.contest.ContestSubmission;
import org.vu.contest.ContestEvaluation;

import java.util.Random;
import java.util.Properties;

import java.util.ArrayList;

import evo.child;

public class player39 implements ContestSubmission
{
  private Random rnd_;
  private ContestEvaluation evaluation_;
  private int evaluations_limit_;

  private int populationSize_ = 0;

  private ArrayList<child> population_ = null;

  public player39()
  {
    rnd_ = new Random();
  }

  public void setSeed(long seed)
  {
    // Set seed of algortihms random process
    rnd_.setSeed(seed);
  }

  public void setEvaluation(ContestEvaluation evaluation)
  {
    // Set evaluation problem used in the run
    evaluation_ = evaluation;

    // Get evaluation properties
    Properties props = evaluation.getProperties();
    evaluations_limit_ = Integer.parseInt(props.getProperty("Evaluations"));
    boolean isMultimodal = Boolean.parseBoolean(props.getProperty("Multimodal"));
    boolean hasStructure = Boolean.parseBoolean(props.getProperty("Regular"));
    boolean isSeparable = Boolean.parseBoolean(props.getProperty("Separable"));

    //set population size
    populationSize_ = 100;


    initializePopulation();


    // Change settings(?)
    if(isMultimodal){
      // Do sth
    }else if(hasStructure){
      // Do sth else
    }else if(isSeparable){

    }
  }


  public void initializePopulation(){

      population_ = new ArrayList<child>();

      for(int i=0; i < populationSize_; i++){
        double cxs[] = {Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()};

        child c = new child(cxs);

        population_.add(c);
      }  

  }

  // public void recombine(){

  // }

  // public void mutate(){
    
  // }

  // public void survivors(){

  // }

  public void run()
  {
    // Run your algorithm here



    int evals = 0;
    while(evals<evaluations_limit_){



      for(int i=0; i< population_.size(); i++){
        //evaluate childs
        double f = (double) evaluation_.evaluate((population_.get(i)).getCoordinates());
        // System.out.println("Fitness:"+ f);
        // Select parents
        // Apply variation operators and get children
        //  double child[] = ...
        //   Double fitness = evaluation_.evaluate(child);

        //do random permuation on child
        // population_.get(i)[0] += Math.random();
        // population_.get(i)[1] += Math.random();
        // population_.get(i)[2] += Math.random();
        // population_.get(i)[3] += Math.random();
        // population_.get(i)[4] += Math.random();
        // population_.get(i)[5] += Math.random();
        // population_.get(i)[6] += Math.random();
        // population_.get(i)[7] += Math.random();
        // population_.get(i)[8] += Math.random();
        // population_.get(i)[9] += Math.random();

        evals++;

      }

            //select k individuals 
      //pick z best individuals from the selection

      // Select survivors
    }
  }
}
