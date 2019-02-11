package com.mcfarevee.groceries;

public class Weight {
  private Unit unit;
  private int amount;

  public Weight(Unit unit, int amount) {
    this.amount = amount;
    this.unit = unit;
  }

  public Unit getUnit() {
    return unit;
  }

  public int getAmount() {
    return amount;
  }

  public boolean equals(Weight other) {
    return ((this.getAmount() == other.getAmount()) && (this.getUnit().equals(other.getUnit())));
  }
}
