import org.vu.contest.ContestSubmission;
import org.vu.contest.ContestEvaluation;

import java.util.Random;
import java.util.Properties;

import java.util.ArrayList;

import evo.Child;
import evo.EvoAlgorithm;
import evo.Population;
import evo.combination.*;
import evo.mutation.*;
import evo.selection.parent.*;
import evo.selection.survivor.Elitism;
import evo.selection.survivor.*;


public class player39 implements ContestSubmission
{
  private Random rnd_;
  private ContestEvaluation evaluation_;
  private int evaluations_limit_;

  private int populationSize_ = 0;

  private EvoAlgorithm algo = null;
  
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
    populationSize_ = 10;
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
    
    Population pop = new Population(); 

    for(int i=0; i < populationSize_; i++){
        double newCoordinates[] = {0,0,0,0,0,0,0,0,0,0};
        double upper = 5; //max range
        double lower = -5; //min range
        newCoordinates[0] = Math.random()*(upper - lower) + lower;
        newCoordinates[1] = Math.random()*(upper - lower) + lower;
        newCoordinates[2] = Math.random()*(upper - lower) + lower;
        newCoordinates[3] = Math.random()*(upper - lower) + lower;
        newCoordinates[4] = Math.random()*(upper - lower) + lower;
        newCoordinates[5] = Math.random()*(upper - lower) + lower;
        newCoordinates[6] = Math.random()*(upper - lower) + lower;
        newCoordinates[7] = Math.random()*(upper - lower) + lower;
        newCoordinates[8] = Math.random()*(upper - lower) + lower;
        newCoordinates[9] = Math.random()*(upper - lower) + lower;

        Child c = new Child(newCoordinates);
        //add childs to population
        pop.addChild(c);
      }  

    
    Parent selectionP = new FitnessProportional();
    Survivor selectionS = new Elitism(this.populationSize_);
    Combination combination = new Singlepoint();
    Mutation mutation = new Uniform();

    this.algo = new EvoAlgorithm(selectionP,selectionS, mutation, combination, pop);

    //evaluate first time set set initial fitness
    this.algo.EvaluatePopulation(this.evaluation_);

  }

  public void run()
  {
    // Run your algorithm here
    int evals = 0;
    //substract 1 due to the initialization cycle
    while(evals<(evaluations_limit_/this.algo.getPopulation().population_.size())-1){

      ArrayList<Population> parents = algo.ParentSelection();

      Population offspring = new Population();
      for(int i = 0; i < parents.size(); i++){
        Population ps = parents.get(i);
        Child c = algo.Recombination(ps);
        offspring.addChild(c);
      }

      //mutate every child
      for(int i = 0; i < offspring.population_.size(); i++){
        offspring.population_.set(i, (Child) this.algo.Mutation(offspring.population_.get(i))); 
      }

      //evaluate populaiton
      algo.EvaluatePopulation(this.evaluation_);

      //do survivor selection
      algo.SurvivorSelection(offspring);
      // System.out.println(evals);
      // System.out.println(evaluations_limit_);
      evals++;

    }
  }
}
