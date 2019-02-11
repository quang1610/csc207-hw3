package com.mcfarevee.groceries;

public class ManyPackages implements Item {

  private Package type;
  private int count;

  public ManyPackages(Package type, int count) {
    this.type = type;
    this.count = count;
  }

  @Override
  public Weight getWeight() {
    return new Weight(this.type.getWeight().getUnit(),
        this.type.getWeight().getAmount() * this.count);
  }

  @Override
  public int getPrice() {
    return this.type.getPrice()*this.count;
  }

  public String toString() {
    return this.count + " x " + this.type.toString();
  }

  public boolean equals(ManyPackages other) {
    return this == other;
  }
}
