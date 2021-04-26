import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballService {

    private Scanner scanner;

    public void start() {
        boolean isPlay = true;
        Baseball baseball;
        baseball = new Baseball();
        baseball.setOpponentNumber(BaseUtil.getRandomNumber());
        while (isPlay) {
            baseball.init();
            baseball.setUserNumber(getUserNumber());
            baseball.compare();
            isPlay = baseball.isStrike() ? confirmEndOfGame(baseball) : outputResult(baseball);
        }
    }

    private boolean confirmEndOfGame(Baseball baseball) {
        boolean isRestart = false;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시직하려면 1, 종료하려면 2를 입력하세요.");
        initScanner();
        if (scanner.nextInt() == 1) {
            baseball.setOpponentNumber(BaseUtil.getRandomNumber());
            isRestart = true;
        }
        return isRestart;
    }

    private boolean outputResult(Baseball baseball) {
        System.out.println(baseball.toString());
        return true;
    }

    private void initScanner() {
        scanner = new Scanner(System.in);
    }

    private List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요: ");
        initScanner();
        int inputNumber = scanner.nextInt();
        while (inputNumber > 0) {
            userNumber.add(inputNumber % 10);
            inputNumber /= 10;
        }
        Collections.reverse(userNumber);
        return userNumber;
    }

}