package exceptions;
public class EmailAlreadyExists extends Exception {
 private static final long serialVersionUID = 1L;
 
 public EmailAlreadyExists()
  {
    super();
  }
  /**This exception is triggered if the event has already finished
  *@param s String of the exception
  */
  public EmailAlreadyExists(String s)
  {
    super(s);
  }
}