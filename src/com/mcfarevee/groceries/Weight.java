package com.mcfarevee.groceries;

public class Weight {
  private Unit unit;
  private int amount;

  public Weight(Unit unit, int amount) {
    this.amount = amount;
    this.unit = unit;
  }

  public Unit getUnit() {
    return this.unit;
  }

  public int getAmount() {
    return this.amount;
  }
  
  public void setAmount(int newAmount) {
    this.amount = newAmount;
  }

  public boolean equals(Weight other) {
    return ((this.getAmount() == other.getAmount()) && (this.getUnit().equals(other.getUnit())));
  }
}
