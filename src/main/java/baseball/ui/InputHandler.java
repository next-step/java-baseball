package baseball.ui;

import baseball.app.NumberValidator;
import java.util.Scanner;

/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class InputHandler {

  private static final Scanner scanner = new Scanner(System.in);

  public static Integer input() {
    int inputNumber = 0;
    boolean isValidInputNumber = false;
    do{
      System.out.print("숫자를 입력해주세요 : ");
      inputNumber = scanner.nextInt();
      isValidInputNumber = NumberValidator.valid(inputNumber);
    }while(!isValidInputNumber);
    return inputNumber;
  }

  public static Integer insertCoin() {
    return scanner.nextInt();
  }

}
