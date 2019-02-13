package com.mcfarevee.shopping;

//This class utilizes the methods in the 'groceries' package to construct a 'shopping cart' 
//The cart keeps track of these items and their attributes

import java.util.ArrayList;
import java.util.Iterator;
import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;

public class Cart {
  
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  //Initializes the array list which will hold items in the cart
  private ArrayList<Item> cart;
  
  //Records the current total price
  private int totalPrice;
  
  //Records the current total weights of each unit catagory
  private Weight[] weightList;
  
  //Records the current number of things in the cart
  private int numThings;
  
  //Records the current number of entries in the cart
  private int numEntries;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  
  //Create a new cart
  public Cart() {
    this.cart = new ArrayList<Item>();
    this.totalPrice = 0;
    this.numEntries = 0;
    this.numThings = 0;
    this.weightList = new Weight[] {new Weight(Unit.POUND, 0), new Weight(Unit.OUNCE, 0),
        new Weight(Unit.KILOGRAM, 0), new Weight(Unit.GRAM, 0)};
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  
  //Prints the contents of the cart
  public void printContents() {
    for (Item item : this.cart) {
      System.out.println(item.toString());
    }
  }

  //Adds an item to the cart
  //This method also updates all the relevant fields which record attributes of the items in the cart
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
  public Weight[] getWeight() {
    return this.weightList;
  }
  //Merges any like BulkItems or Package/ManyPackage items into a single item in the cart
  public void merge() { 
    int amount = 0; //Fields for tracking combined amounts of the two items
    for (int x = 0; x < cart.size(); x++) { 
      Item i;
      Item j;
      for(int y = x + 1; y < cart.size(); y++) { //Iterate through every item on the list
        i = cart.get(x);
        j = cart.get(y);
        if (i.getName().contentEquals(j.getName())) { //Conditionals for every combination of Package/ManyPackage
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
          } else if (i instanceof BulkItem) { //Conditional for BuikItem
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

  //Return number of entries
  public int numEntries() {
    return this.numEntries;
  }

  //Return number of things
  public int numThings() {
    return this.numThings;
  }
  public int getPrice() {
    return this.totalPrice;
  }
 //https://stackoverflow.com/questions/223918/iterating-through-a-collection-avoiding-concurrentmodificationexception-when-re
  //Remove an item with the specific string
  public void remove(String name) {
    for (Iterator<Item> iterator = cart.iterator(); iterator.hasNext();) {
      Item item = iterator.next();
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

        iterator.remove();
      }
    }
  }

}
