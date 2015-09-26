package evo.selection.survivor;

import evo.selection.survivor.Survivor;
import evo.Population;

public class Elitism implements Survivor{
  public Elitism(){
    
  }
  public Population select(Population aPopulation, Population offspring){
    return(aPopulation);
  } 
}