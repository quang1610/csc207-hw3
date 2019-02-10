package com.mcfarevee.groceries;

public class BulkItem implements Item{
  private BulkFood food;
  private Unit unit;
  private int amount;
  
  public BulkItem(BulkFood food, Unit unit, int amount) {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  }

  @Override
  public Weight getWeight() {
    return new Weight(unit, amount);
  }

  @Override
  public int getPrice() {
    return food.getPricePerUnit()*this.amount;
  }
  
  public String toString() {
    return amount+" "+unit.name+" of "+food.getName();
  }
  public BulkFood getFood() {
    return this.food;
  }
  public Unit getUnit() {
    return this.unit;
  }
  public int getAmount() {
    return this.amount;
  }
  public boolean equals(BulkItem b){
    if(this.food == b.getFood()&&this.unit == b.getUnit() && this.amount == b.getAmount()) {
      return true;
    }
    else {
      return false;
    }
    
  }
  

}
