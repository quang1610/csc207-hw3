package com.mcfarevee.groceries;

public class Package implements Item {

  private String name;
  private Weight weight;
  private int price;

  public Package(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  public String getName() {
    return this.name;
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
    return weight.getAmount() + " " + weight.getUnit().abbrev() + " package of " + name;
  }

  public boolean equals(Package p) {
    if ((this.toString().equals(p.toString())) && (this.getPrice() == p.getPrice())) {
      return true;
    } else {
      return false;
    }

  }

}
