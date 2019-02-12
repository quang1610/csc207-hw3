package com.mcfarevee.groceries;

public class Weight {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //The Unit of the Weight, as described in the Unit class
  private Unit unit;

  //The amount of the Weight
  private int amount;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  //Creates a new Weight
  public Weight(Unit unit, int amount) {
    this.amount = amount;
    this.unit = unit;
  }

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  //Gets the Unit of the Weight, as described in the Unit class
  public Unit getUnit() {
    return this.unit;
  }

  //Gets the amount or quantity of the Weight
  public int getAmount() {
    return this.amount;
  }
  
  //Sets the amount field to a new value
  public void setAmount(int newAmount) {
    this.amount = newAmount;
  }

  //Returns true if the fields of two Weights are equal
  public boolean equals(Weight other) {
    return ((this.getAmount() == other.getAmount()) && (this.getUnit().equals(other.getUnit())));
  }
}
