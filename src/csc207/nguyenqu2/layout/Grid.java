package csc207.nguyenqu2.layout;
//creates a grid of characters as a TextBlock
public class Grid implements TextBlock {
  private int width;//width of grid
  private int height;//height of grid
  private char c;//character that makes up the grid
  //initializes fields based on input and throws exception if width or height is negative
  public Grid(int width, int height, char c) throws Exception {
    if((width < 0) || (height < 0)) {
      throw new Exception("Invalid Grid size!");
    }
    this.width = width;
    this.height = height;
    this.c = c;
  }
  //returns a row of width amount of characters
  public String row(int row) throws Exception{
    if (row >= this.height) {
      throw new Exception("Invalid Grid row number!");
    } else {
      String currentString = new String() + c; 
      while (currentString.length() < this.width) {
        currentString = currentString.concat(currentString);
      } // while
      
      return currentString.substring(0, this.width);
    }
  }
  //gets the width of the grid
  public int width() {
    return this.width;
  }
  //gets the height of the grid
  public int height() {
    return this.height;
  }
}
