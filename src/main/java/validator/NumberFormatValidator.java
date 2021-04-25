package validator;

public class NumberFormatValidator implements Validator {

  @Override
  public void validate(String input) {
    checkParseToInteger(input);
    checkDifferentNumber(input);
    checkNumberLength(input);
  }

  private void checkParseToInteger(String input) {

  }

  private void checkDifferentNumber(String input) {

  }

  private void checkNumberLength(String input) {

  }

}
