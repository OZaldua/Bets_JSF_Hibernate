package exceptions;
public class EmailNotExists extends Exception {
 private static final long serialVersionUID = 1L;
 
 public EmailNotExists()
  {
    super();
  }
  /**This exception is triggered if the event has already finished
  *@param s String of the exception
  */
  public EmailNotExists(String s)
  {
    super(s);
  }
}