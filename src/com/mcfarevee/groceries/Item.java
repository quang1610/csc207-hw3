package com.mcfarevee.groceries;

/* This is the interface for an Item */

public interface Item {

  //All items have an accessor which retrieves their weight
  public Weight getWeight(); 

  //All items have an accessor which retrieves their price
  public int getPrice();

  //All items have an accessor which retrieves a string description of the item
  public String toString();

  //All items have an accessor which retrieves a string of the name
  public String getName();
}
