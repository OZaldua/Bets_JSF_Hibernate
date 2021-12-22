package exceptions;
public class WrongPassword extends Exception {
 private static final long serialVersionUID = 1L;
 
 public WrongPassword()
  {
    super();
  }
  /**This exception is triggered if the question already exists 
  *@param s String of the exception
  */
  public WrongPassword(String s)
  {
    super(s);
  }
}