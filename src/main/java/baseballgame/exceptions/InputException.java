package baseballgame.exceptions;

public class InputException extends RuntimeException {
  /**
   *
   */
  private static final long serialVersionUID = -2750909374547056731L;

  public InputException() {
    super();
  }

  public InputException(String message) {
    super(message);
  }
}
