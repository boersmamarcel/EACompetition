package evo.selection.parent;
import evo.selection.parent.Parent;
import evo.Population;
import java.util.ArrayList;
import java.util.Collections;
import evo.Child;
import java.util.Random;

public class UniformSelection implements Parent{
      
      private int numberOfParentsSelected = 10; //should be even for the recombination

      public UniformSelection(){

      }

      public ArrayList<Population> select(Population aPopulation){
        //randomize population
        Collections.shuffle(aPopulation.population_);

        //make a list of parent populations
        ArrayList<Population> parentsList = new ArrayList<Population>();

        Random rnd = new Random();

        for(int i = 0; i < this.numberOfParentsSelected; i++){
          Population ps = new Population();
          ps.addChild(aPopulation.population_.get(rnd.nextInt(aPopulation.population_.size()))); //add first parent
          ps.addChild(aPopulation.population_.get(rnd.nextInt(aPopulation.population_.size()))); //add second parent
          parentsList.add(ps); //add one pair of parents
        }

        return (parentsList);
    } 
}