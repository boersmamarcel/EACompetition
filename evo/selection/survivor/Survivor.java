package evo.selection.survivor;
import evo.Population;
public interface Survivor{
    public Population select(Population aPopulation, Population offspring); 
}