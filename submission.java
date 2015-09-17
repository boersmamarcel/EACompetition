import org.vu.contest.ContestSubmission;
import org.vu.contest.ContestEvaluation;

import java.util.Random;
import java.util.Properties;

import java.util.ArrayList;

public class submission implements ContestSubmission
{
  private Random rnd_;
  private ContestEvaluation evaluation_;
  private int evaluations_limit_;

  public submission()
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

    // Change settings(?)
    if(isMultimodal){
      // Do sth
    }else{
      // Do sth else
    }
  }

  public void run()
  {
    // Run your algorithm here

    ArrayList <double[]> population = new ArrayList<double[]>();
    double child[] = {Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()};
    population.add(child);
    population.add(child);
    population.add(child);


    int evals = 0;
    while(evals<evaluations_limit_){

      for(int i=0; i< population.size(); i++){
        //evaluate childs
        evaluation_.evaluate(population.get(i));
        // Select parents
        // Apply variation operators and get children
        //  double child[] = ...
        //   Double fitness = evaluation_.evaluate(child);

        //do random permuation on child
        population.get(i)[0] += Math.random();
        population.get(i)[1] += Math.random();
        population.get(i)[2] += Math.random();
        population.get(i)[3] += Math.random();
        population.get(i)[4] += Math.random();
        population.get(i)[5] += Math.random();
        population.get(i)[6] += Math.random();
        population.get(i)[7] += Math.random();
        population.get(i)[8] += Math.random();
        population.get(i)[9] += Math.random();

        evals++;

      }
      // Select survivors
    }
  }
}
