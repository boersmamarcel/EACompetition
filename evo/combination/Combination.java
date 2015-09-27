package evo.combination;
import evo.Child;
import evo.Population;

public interface Combination{
  public Child[] combine(Population parents);
}