package csc207.nguyenqu2.layout;
/*
 * creates a TextBlock that is truncated to a specified width
 */
public class TruncatedBlock implements TextBlock {
  private TextBlock text;//original textblock
  private int width;//total width of truncated block
  
  public TruncatedBlock(TextBlock tb, int width) throws Exception{
    if((width < 0) || (width > tb.width()))
    {
      throw new Exception("Invalid width!");
    } else {
      this.width = width; 
      this.text = tb;
    }
  }
  /*
   * @return gets the height
   */
  public int height() {
    return this.text.height();
  }
  /*
   * @return gets the width
   */
  public int width() {
    if(this.width>this.text.width()) {
      System.err.println("Invalid width!");
      System.exit(0);

    }
    return this.width;
  }
  /*@param integer representing the row
   * @return truncated row
   */
  public String row(int i) throws Exception {
    String row = this.text.row(i);
    return row.substring(0, width());
  }
}
