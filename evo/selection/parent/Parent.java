package evo.selection.parent;
import evo.Population;
import java.util.ArrayList;

public interface Parent{
  
    public ArrayList<Population> select(Population aPopulation);

}