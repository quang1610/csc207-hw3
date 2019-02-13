package csc207.nguyenqu2.layout;
/*creates a TextBlock of a given width and makes the the text in a given 
 * TextBlock right justified within this block
*/
public class RightJustified implements TextBlock{
  private TextBlock text;//TextBlock to be right justified
  private int width;//total width of RightJustified
  public RightJustified(TextBlock text, int width) throws Exception{
    if(width < text.width()) {
      throw new Exception("Invalid width!");
    }
    this.text = text;
    this.width  = width;
  }
  /* @param integer representing the row in the block
   * @returns the right justified string
   */
  public String row(int i) throws Exception {
    if((i<0)||(i>height())){
      throw new Exception("Invalid row!");
    }
    else {
      int spaces = (this.width() - this.text.width());
      return TBUtils.spaces(spaces)+this.text.row(i);
    }
    
  }
  /*
   * @return gets the width
   */
  public int width() {
    if(this.text.width()>this.width) {
      System.err.println("Invalid width!");
      System.exit(0);
    }
    return this.width;
  }
  /*
   * @return gets the width
   */
  public int height() {
    return this.text.height();
  }

}
