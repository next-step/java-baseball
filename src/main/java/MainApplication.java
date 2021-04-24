import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class MainApplication {

  public static void main(String[] args) {
    MainApplication mainApplication = new MainApplication();

    String randomNumber = mainApplication.makeRandomNumber(3);
    boolean exit = false;
    Scanner scanner = new Scanner(System.in);
    while (!exit) {
      System.out.print("숫자를 입력해주세요 : ");
      String inputNumber = scanner.nextLine();

      int strike = mainApplication.validateStrike(randomNumber, inputNumber);
      int ball = mainApplication.validateBall(randomNumber, inputNumber);
      mainApplication.printResult(strike, ball);
    }
  }

  // 난수 생성
  private String makeRandomNumber(int length) {
    String NUMBERS = "123456789";

    Random random = new SecureRandom();

    StringBuilder randomNumber = new StringBuilder();

    for (int i = 0; i < length; i++) {
      randomNumber.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
    }

    return randomNumber.toString();
  }

  // Strike 확인
  private int validateStrike(String randomNumber, String inputNumber) {
    int strike = 0;
    for (int i = 0; i < randomNumber.length(); i++) {
      if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
        strike++;
      }
    }

    return strike;
  }

  // Ball 확인
  private int validateBall(String randomNumber, String inputNumber) {
    int ball = 0;
    for (int i = 0; i < randomNumber.length(); i++) {
      if (randomNumber.charAt(i) != inputNumber.charAt(i)
          && randomNumber.contains(String.valueOf(inputNumber.charAt(i)))) {
        ball++;
      }
    }

    return ball;
  }

  // 결과 출력
  private void printResult(int strike, int ball) {
    if (strike > 0) {
      System.out.print(strike + " 스트라이크 ");
    }
    if (ball > 0) {
      System.out.print(ball + " 볼");
    }
    System.out.println();
  }
}
