package com.mcfarevee.groceries;

/* This is the interface for an Item */

public interface Item {

  //All items have an accessor which retreives their weight
  public Weight getWeight(); 

  //All items have an accessor which retreives their pricee
  public int getPrice();

  //All items have an accessor which retreives a string discription of the item
  public String toString();
}
