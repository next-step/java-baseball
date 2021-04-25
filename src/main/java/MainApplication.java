import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainApplication {

  public static void main(String[] args) {
    MainApplication mainApplication = new MainApplication();

    String randomNumber = null;
    boolean exit = false;
    boolean newGame = true;
    Scanner scanner = new Scanner(System.in);
    while (!exit) {
      if (newGame) {
        randomNumber = mainApplication.generateRandomNumber(3);
        newGame = false;
      }
      System.out.print("숫자를 입력해주세요 : ");
      String inputNumber = scanner.nextLine();

      int strike = mainApplication.validateStrike(randomNumber, inputNumber);
      int ball = mainApplication.validateBall(randomNumber, inputNumber);
      mainApplication.printResult(strike, ball);

      if (strike == 3) {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        exit = !mainApplication.checkRestartGame();
        newGame = exit;
      }
    }
  }

  // 난수 생성
  private String generateRandomNumber(int length) {
    List<String> numbers =
        new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    Random random = new Random();
    StringBuilder randomNumber = new StringBuilder();

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(numbers.size() - 1);
      randomNumber.append(numbers.get(index));
      numbers.remove(index);
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

  // 다시 시작 여부 확인
  private boolean checkRestartGame() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요.");
    int input = scanner.nextInt();

    return input == 1;
  }
}
