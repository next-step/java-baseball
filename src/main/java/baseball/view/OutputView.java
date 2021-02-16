package baseball.view;

import baseball.domain.Baseball;

import static baseball.view.ViewStringContants.*;

public class OutputView {
    public static void inputNumber() {
        System.out.println(INPUT_NUMBERS.toString());
    }

    public static void gameMessage(Baseball baseball) {
        int strikes = baseball.getPlayerStrikes();
        int balls = baseball.getPlayerBalls();
        StringBuilder message = new StringBuilder();
        if (balls == 0 && strikes == 0) {
            message.append("낫싱");
            System.out.println(message.toString());
            return;
        }
        if (balls > 0) {
            message.append(balls + " 볼 ");
        }
        if (strikes > 0) {
            message.append(strikes + " 스트라이크 ");
        }
        System.out.println(message.toString());
    }

    public static void result() {
        System.out.println(GAME_END.toString());
    }

    public static void end() {
        System.out.println(ASK_REGAME.toString());
    }
}
