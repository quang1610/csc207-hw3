package com.mcfarevee.groceries;

public class NonFood implements Item {

  private String name;
  private Weight weight;
  private int price;

  public NonFood(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  @Override
  public Weight getWeight() {
    return this.weight;
  }

  @Override
  public int getPrice() {
    return this.price;
  }

  public String toString() {
    return this.name;
  }

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
