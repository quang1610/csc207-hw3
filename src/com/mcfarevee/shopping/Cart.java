package com.mcfarevee.shopping;


import java.util.ArrayList;
import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;

public class Cart {
  private ArrayList<Item> cart;
  private int totalPrice;
  private Weight[] weightList;
  private int numThings;
  private int numEntries;

  public Cart() {
    this.cart = new ArrayList<Item>();
    this.totalPrice = 0;
    this.numEntries = 0;
    this.numThings = 0;
    this.weightList = new Weight[] {new Weight(Unit.POUND, 0), new Weight(Unit.OUNCE, 0),
        new Weight(Unit.KILOGRAM, 0), new Weight(Unit.GRAM, 0)};
  }

  public void printContents() {
    for (Item item : this.cart) {
      System.out.println(item.toString());
    }
  }

  public void addItem(Item item) {
    this.cart.add(item);

    this.totalPrice += item.getPrice();

    Unit itemUnit = item.getWeight().getUnit();
    if (itemUnit.equals(Unit.POUND)) {
      this.weightList[0].setAmount(this.weightList[0].getAmount() + item.getWeight().getAmount());
    } else if (itemUnit.equals(Unit.OUNCE)) {
      this.weightList[1].setAmount(this.weightList[1].getAmount() + item.getWeight().getAmount());
    } else if (itemUnit.equals(Unit.KILOGRAM)) {
      this.weightList[2].setAmount(this.weightList[2].getAmount() + item.getWeight().getAmount());
    } else if (itemUnit.equals(Unit.GRAM)) {
      this.weightList[3].setAmount(this.weightList[3].getAmount() + item.getWeight().getAmount());
    }

    if (item instanceof ManyPackages) {
      this.numThings += ((ManyPackages) item).getCount();
    } else {
      this.numThings++;
    }

    this.numEntries++;
  }

/*
  public void merge() {
    int amount = 0;
    for (Item i : cart) {
      for (Item j : cart) {
        if (i != j) {
          if (i.getName().contentEquals(j.getName())) {
            if (i instanceof Package) {
              amount = 1;
              if ((j instanceof Package) && (((Package) i).equals((Package) j))) {
                amount++;
                cart.remove(j);
                numEntries--;
              } else if ((j instanceof ManyPackages)
                  && ((Package) i).equals(((ManyPackages) j).getPackage())) {
                amount += ((ManyPackages) j).getCount();
                cart.remove(j);
                numEntries--;
              }
              i = new ManyPackages((Package) i, amount);
            } else if (i instanceof ManyPackages) {
              amount = ((ManyPackages) i).getCount();
              if ((j instanceof Package) && ((Package) j).equals(((ManyPackages) i).getPackage())) {
                amount += 1;
                cart.remove(j);
                numEntries--;
              } else if ((j instanceof ManyPackages)
                  && ((ManyPackages) i).getPackage().equals(((ManyPackages) j).getPackage())) {
                amount += ((ManyPackages) j).getCount();
                cart.remove(j);
                numEntries--;
              }
              i = new ManyPackages(((ManyPackages) i).getPackage(), amount);
            } else if (i instanceof BulkItem) {
              amount = ((BulkItem) i).getAmount();
              if ((j instanceof BulkItem)
                  && ((BulkItem) i).getFood().equals(((BulkItem) j).getFood())) {
                amount += ((BulkItem) j).getAmount();
                cart.remove(j);
                numEntries--;
              }
              i = new BulkItem(((BulkItem) i).getFood(), ((BulkItem) i).getUnit(), amount);
            }
          }
        }
      }
    }
  }
  */
  
  public void merge() { 
    int amount = 0;
    for (int x = 0; x < cart.size(); x++) { 
      Item i;
      Item j;
      for(int y = x + 1; y < cart.size(); y++) {
        i = cart.get(x);
        j = cart.get(y);
        if (i.getName().contentEquals(j.getName())) {
          if (i instanceof Package) {
            amount = 1;
            if ((j instanceof Package) && (((Package) i).equals((Package) j))) {
              amount++;
              cart.remove(j);
              numEntries--;
              y--;
              cart.set(x, new ManyPackages((Package) i, amount));
            } else if ((j instanceof ManyPackages)
                && ((Package) i).equals(((ManyPackages) j).getPackage())) {
              amount += ((ManyPackages) j).getCount();
              cart.remove(j);
              numEntries--;
              y--;
              cart.set(x, new ManyPackages((Package) i, amount));
            }
          } else if (i instanceof ManyPackages) {
            amount = ((ManyPackages) i).getCount();
            if ((j instanceof Package) && ((Package) j).equals(((ManyPackages) i).getPackage())) {
              amount += 1;
              cart.remove(j);
              numEntries--;
              y--;
              cart.set(x, new ManyPackages(((ManyPackages) i).getPackage(), amount));
            } else if ((j instanceof ManyPackages)
                && ((ManyPackages) i).getPackage().equals(((ManyPackages) j).getPackage())) {
              amount += ((ManyPackages) j).getCount();
              cart.remove(j);
              numEntries--;
              y--;
              cart.set(x, new ManyPackages(((ManyPackages) i).getPackage(), amount));
            }
          } else if (i instanceof BulkItem) {
            amount = ((BulkItem) i).getAmount();
            if ((j instanceof BulkItem)
                && ((BulkItem) i).getFood().equals(((BulkItem) j).getFood())) {
              amount += ((BulkItem) j).getAmount();
              cart.remove(j);
              numEntries--;
              y--;
              cart.set(x, new BulkItem(((BulkItem) i).getFood(), ((BulkItem) i).getUnit(), amount));
            }
          }
        }
      }
    }
  }



  public int numEntries() {
    return this.numEntries;
  }

  public int numThings() {
    return this.numThings;
  }

  public void remove(String name) {
    for (Item item : this.cart) {
      if (item.getName().contentEquals(name)) {
        this.totalPrice -= item.getPrice();

        Unit itemUnit = item.getWeight().getUnit();
        if (itemUnit.equals(Unit.POUND)) {
          this.weightList[0]
              .setAmount(this.weightList[0].getAmount() - item.getWeight().getAmount());
        } else if (itemUnit.equals(Unit.OUNCE)) {
          this.weightList[1]
              .setAmount(this.weightList[1].getAmount() - item.getWeight().getAmount());
        } else if (itemUnit.equals(Unit.KILOGRAM)) {
          this.weightList[2]
              .setAmount(this.weightList[2].getAmount() - item.getWeight().getAmount());
        } else if (itemUnit.equals(Unit.GRAM)) {
          this.weightList[3]
              .setAmount(this.weightList[3].getAmount() - item.getWeight().getAmount());
        }

        if (item instanceof ManyPackages) {
          this.numThings -= ((ManyPackages) item).getCount();
        } else {
          this.numThings--;
        }

        this.numEntries--;

        cart.remove(item);
      }
    }
  }

}
