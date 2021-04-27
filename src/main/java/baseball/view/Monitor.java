package baseball.view;

import baseball.config.BaseballConfig;
import baseball.utils.NumberUtils;
import baseball.value.Message;
import baseball.value.Result;

import java.util.Scanner;

public class Monitor {

    public int askAnswer() {
        int answer = askNumber(Message.USER_INPUT);
        if (!NumberUtils.checkPlace(answer, BaseballConfig.BALL_COUNT)) {
            overSize(BaseballConfig.BALL_COUNT);
            answer = askAnswer();
        }
        return answer;
    }

    public void showResult(Result result) {
        if (result.isNothing()) {
            System.out.println(Message.NOTHING);
            return;
        }

        System.out.printf(Message.RESULT, result.getStrike(), result.getBall());
    }

    public int askRestart() {
        return askNumber(Message.RESTART);
    }

    public void showWin() {
        System.out.println(Message.WIN);
    }

    public void notNumber() {
        System.out.println(Message.ONLY_DIGIT);
    }

    public void overSize(int maxSize) {
        System.out.printf(Message.OVER_MAXIMUM, maxSize);
    }

    public int askNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);

        try {
            return scanner.nextInt();
        } catch (Exception e) {
            notNumber();
            return askNumber(message);
        }
    }
}
