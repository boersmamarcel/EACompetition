package evo.selection.parent;
import evo.selection.parent.Parent;
import evo.Population;
import java.util.ArrayList;
import java.util.Collections;
import evo.Child;

public class FitnessProportional implements Parent{
      
      private int numberOfParentsSelected = 4; //should be even for the recombination

      public FitnessProportional(){

      }

      private double totalFitness(Population aPopulation){
        double total = 0.0;
        for(int i = 0; i < aPopulation.population_.size(); i++){
          total += aPopulation.population_.get(i).getFitness();
        }

        return total;
      }



      private Child getRandomChild(Population aPopulation, double scale){
        double randNR = Math.random()*scale;

        for(int i = 0; i < aPopulation.population_.size(); i++){
          randNR -= aPopulation.population_.get(i).getFitness();
          if(randNR <= 0.0){
            return aPopulation.population_.get(i);
          }
        }
        //if non is picked, then it must be the last one
        return(aPopulation.population_.get(aPopulation.population_.size()));
      }

      public ArrayList<Population> select(Population aPopulation){
        //randomize population
        Collections.shuffle(aPopulation.population_);

        double totalWeight = this.totalFitness(aPopulation);

        //make a list of parent populations
        ArrayList<Population> parentsList = new ArrayList<Population>();

        for(int i = 0; i < this.numberOfParentsSelected; i++){
          Population ps = new Population();
          ps.addChild(getRandomChild(aPopulation, totalWeight)); //add first parent
          ps.addChild(getRandomChild(aPopulation, totalWeight)); //add second parent
          parentsList.add(ps); //add one pair of parents
        }

        return (parentsList);
    } 
}