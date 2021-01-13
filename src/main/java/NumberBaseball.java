import java.util.Scanner;

public class NumberBaseball {
  public static void main(String[] args) {
      NumberBaseball nb = new NumberBaseball();
      nb.startGame();
  }

  public void startGame() {
      int gameStart = 1;
      int number;

      Scanner sc = new Scanner(System.in);

      while (gameStart == 1){
          this.resetGame();

          System.out.println("숫자를 입력해 주세요 : ");
          number = sc.nextInt();

          this.playGame(number);

          System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
          gameStart = sc.nextInt();
      }
  }

  private void resetGame() {

  }

  private void playGame(int number) {

  }
}
