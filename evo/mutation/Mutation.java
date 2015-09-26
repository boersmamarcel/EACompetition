package evo.mutation;
import evo.Child;

public interface Mutation{
  public Child mutate(Child aChild);
}