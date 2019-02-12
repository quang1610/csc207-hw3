package com.mcfarevee.groceries;

/* This class organizes the attributes of a number of packages, as described
 * in the 'Package' class */

public class ManyPackages implements Item {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //The Package which this ManyPackage contains multiple of
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
    //Specify the nature of the above-described fields
  }

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  //Get the Weight (as described in the Weight class) of the ManyPackages
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

  //Returns the string which describes the Packages
  public String toString() {
    return this.count + " x " + this.type.toString();
  }
  
  //Returns the count of packages
  public int getCount() {
    return this.count;
  }

  //Changes the count to a new count
  public void setCount(int newCount) {
    this.count = newCount;
  }

  //Returns the type variable
  public Package getPackage() {
    return this.type;
  }

  //Returns the string name of the package
  public String getName() {
    return this.getPackage().getName();
  }

  //Returns true if the two ManyPackages have the same memory location
  public boolean equals(ManyPackages other) {
    return this == other;
  }
}
