package baseball;

import baseball.app.NumberValidator;
import java.util.Random;

/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class ComputerNumberCreator {
  public static Integer create() {
    Random random = new Random();
    Integer computerNumber = 0;
    boolean isValidNumber = false;
    do {
      computerNumber = random.nextInt(999 - 100) + 100;
      isValidNumber = NumberValidator.valid(computerNumber);
    } while(!isValidNumber);

    return computerNumber;
  }

}
