import java.util.Scanner;

public class Baseball {
    Scanner scanner = new Scanner(System.in);

    public void gamePlay() {
        gameEnd();
    }

    public void gameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (scanner.nextInt() == 2) {
            return;
        }
        gamePlay();
    }


}
