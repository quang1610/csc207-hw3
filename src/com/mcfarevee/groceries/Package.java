package com.mcfarevee.groceries;

//The Package class organizes the attributes of a package of food

public class Package implements Item {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //String to contain the name of the package
  private String name;

  //Weight of the package as prescribed in the weight class
  private Weight weight;

  //Price of one package
  private int price;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  //Creates a new Package item
  public Package(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
    //Specify the nature of the above-described fields
  }

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  //Get the Weight (as described in the Weight class) of the Package
  @Override
  public Weight getWeight() {
    return this.weight;
  }

  //Get the price of the Package
  @Override
  public int getPrice() {
    return this.price;
  }
  
  //Returns a string which represents the name of the item
  public String getName() {
    return this.name;
  }

  //Return a string which describes the package's attributes
  public String toString() {
    return weight.getAmount() + " " + weight.getUnit().abbrev() + " package of " + name;
  }

  //Return true if the toString and price of the two Packages are equal
  public boolean equals(Package p) {
    if ((this.toString().equals(p.toString())) && (this.getPrice() == p.getPrice())) {
      return true;
    } else {
      return false;
    }

  }

}
