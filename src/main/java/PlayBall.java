
import java.util.List;
import java.util.Scanner;

public class PlayBall {

    private final UserInputNumber userInput = new UserInputNumber();
    private final CreateGameBall createBall = new CreateGameBall();
    private final CompareBall compareBall = new CompareBall();

    private final Scanner scan = new Scanner(System.in);

    public void gameReady() {
        List<Integer> computerBall;
        int status = 1;
        while (status == 1) {
            compareBall.setStatus(true);
            computerBall = createBall.getBall();
            gameStart(computerBall);
            System.out.print("게임을 계속할려면 1, 그만할려면 2를 입력하세요 :");
            status = scan.nextInt();
        }
    }

    public void gameStart(List<Integer> computerBall) {
        while (compareBall.getStatus()) {
            List<Integer> userNumber = userInput.InputNumber();
            compareBall.checkStart(userNumber, computerBall);
        }
    }
}
