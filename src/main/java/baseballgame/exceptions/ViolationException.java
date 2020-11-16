package baseballgame.exceptions;

public class ViolationException extends RuntimeException {
  /**
   *
   */
  private static final long serialVersionUID = -2750909374547056731L;

  public ViolationException() {
    super();
  }

  public ViolationException(String message) {
    super(message);
  }
}
