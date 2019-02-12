package com.mcfarevee.groceries;

// This class organizes the attributes of the non-food items in the cart

public class NonFood implements Item {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //String to contain the name of the item
  private String name;

  //Contains the weight of the item as prescribed in the Weight class
  private Weight weight;

  //The price of one of these items, in cents
  private int price;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  //Create a new NonFood item
  public NonFood(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
    //Specify the nature of the above-described fields
  }

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  //Get the Weight (as described in the Weight class) of the NonFood item
  @Override
  public Weight getWeight() {
    return this.weight;
  }

  //Get the price of the NonFood item
  @Override
  public int getPrice() {
    return this.price;
  }

  //Returns the name of the item in string form
  public String getName() {
    return this.name;
  }
  
  //Return a string which describes the NonFood item
  public String toString() {
    return this.getName();
  }

  //Returns true if the fields of the two NonFood items match
  public boolean equals(NonFood other) {
    if ((this.toString().equals(other.toString())) && 
        (this.getPrice() == other.getPrice()) && 
        (this.getWeight().equals(other.getWeight()))) {
      return true;
    } else {
      return false;
    }

  }

}
