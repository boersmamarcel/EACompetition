package evo;

import evo.selection.parent.Parent;
import evo.selection.survivor.Survivor;
import evo.mutation.Mutation;
import evo.combination.Combination;
import evo.Population;
import java.util.ArrayList;
import evo.Child;
import org.vu.contest.ContestEvaluation;

public class EvoAlgorithm{

  private Parent parentSelection = null;
  private Survivor survivorSelection = null;
  private Mutation mutation = null;
  private Combination combination = null;
  private Population population = null;

  public EvoAlgorithm(Parent pselection, Survivor sselection, Mutation m, Combination c, Population pop){
    this.parentSelection = pselection;
    this.survivorSelection = sselection;
    this.mutation = m;
    this.combination = c;
    this.population = pop;
  }

  public ArrayList<Population> ParentSelection(){
    return(this.parentSelection.select(this.population));
  }

  public Child Recombination(Population parents){
    return(this.combination.combine(parents));
  }

  public Child Mutation(Child aChild){
    return(this.mutation.mutate(aChild));
  }

  public void SurvivorSelection(Population offspring){
    this.population = this.survivorSelection.select(this.population, offspring);
  }

  public void EvaluatePopulation(ContestEvaluation evaluation){
    // System.out.println(this.population.population_.get(100).getCoordinates()[0]);
      for(int i = 0; i < this.population.population_.size(); i++){
        Child currentChild = (Child) this.population.population_.get(i);
        double f = (double) evaluation.evaluate(currentChild.getCoordinates());
        this.population.population_.get(i).setFitness(f);  
      }
  }

  public Population getPopulation(){
    return this.population;
  }
}


