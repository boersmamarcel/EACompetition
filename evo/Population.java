package evo;

import evo.Child;
import java.util.ArrayList;

public class Population{
 
  
  public ArrayList<Child> population_ = null;

  public Population(){

  }

  public void addChild(Child aChild){
    this.population_.add(aChild);
  }
  
   

}
