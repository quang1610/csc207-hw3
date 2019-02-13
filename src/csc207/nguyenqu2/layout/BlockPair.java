package csc207.nguyenqu2.layout;
//puts two TextBlock side by side
public class BlockPair implements TextBlock{
  private TextBlock text;
  public BlockPair(TextBlock text) throws Exception{
    this.text = text;
  }
  //returns the row of text with a copy next to it
  public String row(int i) throws Exception {
    if((i<0)||(i>height())){
      throw new Exception("Invalid row!");
    }
    else {
      return this.text.row(i)+this.text.row(i);
    }
    
  }
  //gets the width
  public int width() {
    return 2*this.text.width();
  }
  //gets the height
  public int height() {
    return this.text.height();
  }
}
