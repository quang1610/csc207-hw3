package com.mcfarevee.groceries;

/*
 * This class organizes the attributes of a particular food
 * */
public class BulkFood {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //The name of the food
  private String name;

  //The unit which the food is measured in
  private Unit unit;

  //The price per unit defined above, in cents
  private int pricePerUnit;

  //The total supply of that unit in the store
  private int supply;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  //Create a new Bulkfood
  public BulkFood(String name, Unit unit, int pricePerUnit, int supply) {
    this.name = name;
    this.pricePerUnit = pricePerUnit;
    this.unit = unit;
    this.supply = supply;
    //Specify the nature of the above-discribed fields
  }

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  //Get the food name
  public String getName() {
    return this.name;
  }

  //Get the food unit
  public Unit getUnit() {
    return this.unit;
  }

  //Get the food price
  public int getPricePerUnit() {
    return this.pricePerUnit;
  }

  //Get the total supply of the food
  public int getSupply() {
    return this.supply;
  }

}
