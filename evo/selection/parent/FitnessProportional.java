package evo.selection.parent;
import evo.selection.parent.Parent;
import evo.Population;
import java.util.ArrayList;
import java.util.Collections;
import evo.Child;

public class FitnessProportional implements Parent{
      
      private int numberOfParentsSelected = 10; //should be even for the recombination

      public FitnessProportional(){

      }

      private double totalFitness(Population aPopulation){
        double total = 0.0;
        for(int i = 0; i < aPopulation.population_.size(); i++){
          total += Math.abs(aPopulation.population_.get(i).getFitness());
        }

        return total;
      }
 

      //can not handle the negative fitness always selects the last item in the population
      private Child getRandomChild(Population aPopulation, double scale){
        double randNR = Math.random()*scale;

        for(int i = 0; i < aPopulation.population_.size(); i++){
          randNR -= aPopulation.population_.get(i).getFitness();
          if(randNR <= 0.0){
            return aPopulation.population_.get(i);
          }
        }
        //if non is picked, then it must be the last one
        return(aPopulation.population_.get(aPopulation.population_.size()-1));
      }

      public ArrayList<Population> select(Population aPopulation){
        //rescale population in order to make weighted sampling work
        this.rescale_fitness(aPopulation);

        //randomize population
        Collections.shuffle(aPopulation.population_);

        double totalWeight = this.totalFitness(aPopulation);

        //make a list of parent populations
        ArrayList<Population> parentsList = new ArrayList<Population>();

        for(int i = 0; i < this.numberOfParentsSelected; i++){
          Population ps = new Population();
          Child c1 = getRandomChild(aPopulation, totalWeight);
          // System.out.println("RANDOM CHILD");
          // System.out.println(c1);
          ps.addChild(c1); //add first parent
          ps.addChild(getRandomChild(aPopulation, totalWeight)); //add second parent
          parentsList.add(ps); //add one pair of parents
        }

        return (parentsList);
    } 

    private void rescale_fitness(Population pop){
      double minfitness=0.0;
      for(int i=0; i<pop.population_.size(); i++){
        Child c = pop.population_.get(i);
        if (c.getFitness()<minfitness){
          minfitness=c.getFitness();
        }
      }
      for(int i=0; i<pop.population_.size(); i++){
        Child c = pop.population_.get(i);
        // System.out.println("Old fitness:"+c.getFitness()+" new:"+(c.getFitness()+Math.abs(minfitness)));
        c.setFitness(c.getFitness()+Math.abs(minfitness));
      }
    }
}