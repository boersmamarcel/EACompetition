package evo.mutation;
import evo.Child;

public class Uniform implements Mutation{
  public Uniform(){

  }

  public Child mutate(Child aChild){

    double newCoordinates[] = {0,0,0,0,0,0,0,0,0,0};
    newCoordinates[0] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[1] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[2] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[3] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[4] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[5] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[6] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[7] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[8] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;
    newCoordinates[9] = Math.random()*(aChild.maxRange - aChild.minRange) + aChild.minRange;

    //update to new coordinates
    aChild.setCoordinates(newCoordinates);

    return(aChild);
  }
}