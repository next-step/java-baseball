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

      // strike 비교
      int strike = mainApplication.validateStrike(randomNumber, inputNumber);
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

  // 스트라이크 비교
  private int validateStrike(String randomNumber, String inputNumber) {
    int strike = 0;
    char[] randomNumberOfChars = randomNumber.toCharArray();
    char[] inputNumberOfChars = inputNumber.toCharArray();
    for (int i = 0; i < inputNumberOfChars.length; i++) {
      if (randomNumberOfChars[i] == inputNumberOfChars[i]) {
        strike++;
      }
    }

    return strike;
  }
}
