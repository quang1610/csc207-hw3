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
    for(Item item: this.cart) {
      System.out.println(item.toString());
    }
  }

  public void addItem(Item item) {
    this.cart.add(item);
    
    this.totalPrice += item.getPrice();
    
    Unit itemUnit = item.getWeight().getUnit();
    if(itemUnit.equals(Unit.POUND)) {
      this.weightList[0].setAmount(this.weightList[0].getAmount() + item.getWeight().getAmount());
    } else if (itemUnit.equals(Unit.OUNCE)) {
      this.weightList[1].setAmount(this.weightList[1].getAmount() + item.getWeight().getAmount());
    } else if (itemUnit.equals(Unit.KILOGRAM)) {
      this.weightList[2].setAmount(this.weightList[2].getAmount() + item.getWeight().getAmount());
    } else if (itemUnit.equals(Unit.GRAM)) {
      this.weightList[3].setAmount(this.weightList[3].getAmount() + item.getWeight().getAmount());
    }
    
    if(item instanceof ManyPackages) {
      this.numThings += ((ManyPackages)item).getCount();
    } else {
      this.numThings ++;
    }
    
    this.numEntries++;
  }
  

  /*public void merge() {
    for (int i = 0; i < cart.size(); i++) {
      Item itemI = cart.get(i);
      for (int j = i; j < cart.size(); j++) {
        Item itemJ = cart.get(j);
        if (itemI.getName().equals(itemJ.getName())) {
          if ((itemJ instanceof Package) || 
          else if(itemJ instanceof ManyPackages)) {
            

          } else if ((itemJ instanceof BulkItem) || (itemJ instanceof BulkFood) {

          }
          
        }
      }
    }

  }
  */
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
        if(itemUnit.equals(Unit.POUND)) {
          this.weightList[0].setAmount(this.weightList[0].getAmount() - item.getWeight().getAmount());
        } else if (itemUnit.equals(Unit.OUNCE)) {
          this.weightList[1].setAmount(this.weightList[1].getAmount() - item.getWeight().getAmount());
        } else if (itemUnit.equals(Unit.KILOGRAM)) {
          this.weightList[2].setAmount(this.weightList[2].getAmount() - item.getWeight().getAmount());
        } else if (itemUnit.equals(Unit.GRAM)) {
          this.weightList[3].setAmount(this.weightList[3].getAmount() - item.getWeight().getAmount());
        }
        
        if(item instanceof ManyPackages) {
          this.numThings -= ((ManyPackages)item).getCount();
        } else {
          this.numThings --;
        }
        
        this.numEntries--;
        
        cart.remove(item);
      }
    }
  }
  
}
