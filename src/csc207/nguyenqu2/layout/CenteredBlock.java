package csc207.nguyenqu2.layout;

//creates a block with contents of a given TextBlock centered within a certain amount of spaces
public class CenteredBlock implements TextBlock {
  private TextBlock text;//textblock to be centered
  private int width;//total width

  public CenteredBlock(TextBlock text, int width) throws Exception {
    if (width < text.width()) {
      throw new Exception("Invalid width!");
    }
    this.text = text;
    this.width = width;
  }
  //returns a row of centered text
  public String row(int i) throws Exception {
    if ((i < 0) || (i > height())) {
      throw new Exception("Invalid row!");
    } else {
      int spaces = (width() - this.text.width());
      int lSpace;
      int rSpace;
      if (spaces % 2 == 0) {
        lSpace = spaces / 2;
        rSpace = lSpace;
      } else {
        lSpace = (spaces - 1) / 2;// placed more to left when text can't be centered perfectly
        rSpace = lSpace + 1;
      }
      return TBUtils.spaces(lSpace) + this.text.row(i) + TBUtils.spaces(rSpace);
    }

  }
  //gets the width or prints an error if the width of the textblock is larger than the total width
  public int width() {
    if(this.text.width()>this.width) {
      System.err.println("Invalid width!");
      System.exit(0);
    }
    return this.width;
  }
 //gets the height
  public int height() {
    return this.text.height();
  }

}
