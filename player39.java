import org.vu.contest.ContestSubmission;
import org.vu.contest.ContestEvaluation;

import java.util.Random;
import java.util.Properties;

import java.util.ArrayList;

import evo.Child;
import evo.EvoAlgorithm;
import evo.Population;
import evo.combination.Singlepoint;
import evo.combination.Simple;
import evo.combination.Combination;
import evo.combination.Blend;
import evo.selection.parent.UniformSelection;
import evo.mutation.*;
import evo.mutation.NonUniform;
import evo.mutation.SelfAdaptive;
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
  private int evals = 0;
  
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
    populationSize_ = 20;
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
        double upper = -5; //max range
        double lower = 5; //min range
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
    // Parent selectionP = new UniformSelection();
    Survivor selectionS = new Elitism(this.populationSize_);
    // Combination combination = new Singlepoint(0.5);
    Combination combination = new Simple(0.5);
    // Combination combination = new Blend(0.5); //with alpha = 0.5
    // Mutation mutation = new Uniform();
    // Mutation mutation = new NonUniform(0.3); //with std = 0.3
    Mutation mutation = new SelfAdaptive(.7, 100); //with std = 0.3

    this.algo = new EvoAlgorithm(selectionP,selectionS, mutation, combination, pop);

    //evaluate first time set set initial fitness
    this.evals += this.algo.EvaluatePopulation(this.evaluation_);

  }

  public void run()
  {
    // Run your algorithm here

    //substract 1 due to the initialization cycle
    //we should be able the run the total population twice, ie due to the offspring created
    while(evals< (evaluations_limit_ - 2*this.populationSize_)){

      ArrayList<Population> parents = algo.ParentSelection();

      Population offspring = new Population();
      for(int i = 0; i < parents.size(); i++){
        Population ps = parents.get(i);
        Child c[] = algo.Recombination(ps);
        offspring.addChild(c[0]); //add child 1
        offspring.addChild(c[1]); //add child 2
      }

      //mutate every child
      for(int i = 0; i < offspring.population_.size(); i++){
        offspring.population_.get(i).generation = this.algo.count;
        offspring.population_.set(i, (Child) this.algo.Mutation(offspring.population_.get(i))); 
      }

      //get fitness for offspring
      for(int i = 0; i < offspring.population_.size(); i++){
        Child currentChild = (Child) offspring.population_.get(i);
        double f = (double) this.evaluation_.evaluate(currentChild.getCoordinates());
        offspring.population_.get(i).setFitness(f);
        this.evals++;
      }


      //evaluate populaiton
      this.evals += algo.EvaluatePopulation(this.evaluation_);

      //do survivor selection
      algo.SurvivorSelection(offspring);

    }
  }
}
