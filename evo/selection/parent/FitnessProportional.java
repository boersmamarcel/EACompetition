package evo.selection.parent;
import evo.selection.parent.Parent;
import evo.Population;
import java.util.ArrayList;

public class FitnessProportional implements Parent{
      public FitnessProportional(){

      }

       public ArrayList<Population> select(Population aPopulation){
        //make a list of parent populations
        ArrayList<Population> parentsList = new ArrayList<Population>();

        Population ps = new Population();
        ps.addChild(aPopulation.population_.get(0)); //add first parent
        ps.addChild(aPopulation.population_.get(1)); //add second parent

        parentsList.add(ps); //add one pair of parents

        return (parentsList);
      } 
}