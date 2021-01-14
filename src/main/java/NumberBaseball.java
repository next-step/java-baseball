import java.util.Scanner;
import java.util.Random;

public class NumberBaseball {
  Scanner sc = new Scanner(System.in);
  String computerNumber, userNumber;
  int strike=0, ball=0;

  public void startGame() {
    int gameStart = 1;
    while (gameStart == 1){
      this.resetGame();

      this.playGame();

      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      gameStart = sc.nextInt();
    }
  }

  private void resetGame() {
    int[] numbers = new int[3];
    int result = 0;
    Random rand = new Random();

    numbers[0] = rand.nextInt(9)+1;
    result += numbers[0]*100;

    numbers[1] = rand.nextInt(9)+1;
    while (numbers[0] == numbers[1]) {
      numbers[1] = rand.nextInt(9)+1;
    }
    result += numbers[1]*10;

    numbers[2] = rand.nextInt(9)+1;
    while (numbers[0] == numbers[2] || numbers[1] == numbers[2]) {
      numbers[2] = rand.nextInt(9)+1;
    }
    result += numbers[2];

    computerNumber = String.valueOf(result);
  }

  private void playGame() {
    while (true) {
      System.out.println("숫자를 입력해 주세요 : ");
      userNumber = sc.next();

      this.checkResult();

      if (strike == 3) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return;
      }
      else if (ball != 0 && strike != 0) {
        System.out.println(ball+"볼 "+strike+"스트라이크");
      }
      else if (ball != 0 && strike == 0) {
        System.out.println(ball+"볼");
      }
      else if (ball == 0 && strike != 0) {
        System.out.println(strike+"스트라이크");
      }
      else {
        System.out.println("낫싱");
      }
    }
  }

  private void checkResult() {

  }
}
