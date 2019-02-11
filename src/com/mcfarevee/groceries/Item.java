package com.mcfarevee.groceries;

public interface Item {
  public Weight getWeight(); 
  
  public int getPrice();
  
  public String toString();
  
  public String getName();
}
