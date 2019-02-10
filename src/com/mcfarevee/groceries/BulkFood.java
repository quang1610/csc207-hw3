package com.mcfarevee.groceries;

public class BulkFood {
  private String name;
  private Unit unit;
  private int pricePerUnit;
  private int supply;
  public BulkFood(String name, Unit unit, int pricePerUnit, int supply) {
    this.name = name;
    this.pricePerUnit = pricePerUnit;
    this.unit = unit;
    this.supply = supply;
  }
  public String getName() {
    return this.name;
  }
  public Unit getUnit() {
    return this.unit;
  }
  public int getPricePerUnit() {
    return this.pricePerUnit;
  }
  public int getSupply() {
    return this.supply;
  }
  

}
