package com.mcfarevee.groceries;

/* This class organizes the attributes of a number of packages, as discribed
 * in the 'Package' class */

public class ManyPackages implements Item {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //The Package which this ManyPackage contains mutiple of
  private Package type;

  //The number of packages in this ManyPackage
  private int count;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  //Create a new ManyPackage
  public ManyPackages(Package type, int count) {
    this.type = type;
    this.count = count;
    //Specify the nature of the above-discribed fields
  }

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  //Get the Weight (as discribed in the Weight class) of the ManyPackages
  @Override
  public Weight getWeight() {
    return new Weight(this.type.getWeight().getUnit(),
        this.type.getWeight().getAmount() * this.count);
  }

  //Get the total price of the packages which make up the ManyPackages
  @Override
  public int getPrice() {
    return this.type.getPrice() * this.count;
  }

  //Returns the string which discribes the
  public String toString() {
    return this.count + " x " + this.type.toString();
  }

  //Returns true if the two ManyPackages have the same memory location
  public boolean equals(ManyPackages other) {
    return this == other;
  }
}
