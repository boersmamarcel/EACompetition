package evo.selection.parent;
import evo.Population;

public interface Parent{
  
    public Population select(Population aPopulation);

}