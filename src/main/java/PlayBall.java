import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayBall {

    private UserInputNumber userInput = new UserInputNumber();
    private CreateGameBall createBall = new CreateGameBall();

    public PlayBall() {

    }

    public void gameReady() {
        Scanner scan = new Scanner(System.in);
        int status = 1;
        while (status == 1) {
            int[] userNumber = userInput.InputNumber();
            gameStart(userNumber);
            System.out.print("게임을 계속할려면 1 종료할려면 2를 눌러주세요.");
            status = scan.nextInt();
        }
    }

    private void gameStart(int[] userNumber) {

    }
}
