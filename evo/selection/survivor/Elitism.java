package evo.selection.survivor;

import evo.selection.survivor.Survivor;
import evo.Population;
import java.util.Collections;

public class Elitism implements Survivor{

  private int populationSize = 0;

  public Elitism(int popSize){
   this.populationSize = popSize; 
  }
  public Population select(Population aPopulation, Population offspring){
    Population selectedPopulation = new Population();

    selectedPopulation.population_.addAll(aPopulation.population_);
    selectedPopulation.population_.addAll(offspring.population_);

    Collections.sort(selectedPopulation.population_);
    //sort the population on fitness and retain the first POPSIZE
    selectedPopulation.population_.subList(this.populationSize, selectedPopulation.population_.size()).clear();

    return(selectedPopulation);
  } 
}