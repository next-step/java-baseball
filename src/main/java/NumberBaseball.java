import java.util.Scanner;
import java.util.Random;

public class NumberBaseball {
  public static void main(String[] args) {
    NumberBaseball nb = new NumberBaseball();
    nb.startGame();
  }

  public void startGame() {
    int gameStart = 1;
    String userNumber, computerNumber;

    Scanner sc = new Scanner(System.in);

    while (gameStart == 1){
      computerNumber = this.resetGame();

      System.out.println("숫자를 입력해 주세요 : ");
      userNumber = sc.next();

      this.playGame(computerNumber, userNumber);

      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      gameStart = sc.nextInt();
    }
  }

  private String resetGame() {
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

    return String.valueOf(result);
  }

  private void playGame(String target, String number) {

  }
}
