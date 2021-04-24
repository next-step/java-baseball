package baseball;

import java.util.Scanner;

public class GameController {
    public static final int BASEBALL_NUM_LENGTH = 3;

    Catcher catcher;
    Pitcher pitcher;

    public GameController() {
        catcher = new Catcher(BASEBALL_NUM_LENGTH);
        pitcher = new Pitcher(BASEBALL_NUM_LENGTH);
    }

    public void start() {
        do {
            catcher.setScore(pitcher.getPitchingNumber());
            catcher.printScore();
        } while(continues());
    }

    private boolean continues() {
        if (catcher.is3Strike() && wantsEnd()) {
            return false;
        }

        return true;
    }

    private boolean wantsEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();

        if (answer == 1) {
            return true;
        }

        return false;
    }
}