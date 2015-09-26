package evo.mutation;
import evo.Child;

public class Uniform implements Mutation{
  public Uniform(){

  }

  public Child mutate(Child aChild){
    return(aChild);
  }
}