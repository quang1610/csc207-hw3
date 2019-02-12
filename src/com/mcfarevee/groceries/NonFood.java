package com.mcfarevee.groceries;

// This class organizes the attributes of the non-food items in the cart

public class NonFood implements Item {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //String to contain the name of the item
  private String name;

  //Contains the weight of the item as perscribed in the Weight class
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
    //Specify the nature of the above-discribed fields
  }

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  //Get the Weight (as discribed in the Weight class) of the NonFood item
  @Override
  public Weight getWeight() {
    return this.weight;
  }

  //Get the price of the NonFood item
  @Override
  public int getPrice() {
    return this.price;
  }

  //Return a string which discribes the NonFood item
  public String toString() {
    return this.name;
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
