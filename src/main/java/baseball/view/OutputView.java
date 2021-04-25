package baseball.view;

import baseball.domain.Game;
import baseball.domain.GameRules;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void gameRules(GameRules gameRules) {
        List<String> messages = new ArrayList<>();

        if(gameRules.countOfStrike() > 0) {
            messages.add(String.format("%d 스트라이크", gameRules.countOfStrike()));
        }else if(gameRules.countOfBall() > 0) {
            messages.add(String.format("%d 볼", gameRules.countOfBall()));
        }

        if(messages.isEmpty()) {
            System.out.println("실패!!");
            return;
        }

        System.out.println(String.join(" ", messages));
    }

    public static void endGame() {
        System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Game.BALL_SIZE));
    }
}
