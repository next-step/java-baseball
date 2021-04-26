package baseball.view;

import baseball.domain.Game;
import baseball.domain.Score;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void gameStatus(Score score) {
        if(score.isEndGame()) {
            endGame();
            return;
        }

        gameRules(score);
    }

    public static void gameRules(Score score) {
        List<String> messages = new ArrayList<>();

        if(score.countOfStrike() > 0) {
            messages.add(String.format("%d 스트라이크", score.countOfStrike()));
        }else if(score.countOfBall() > 0) {
            messages.add(String.format("%d 볼", score.countOfBall()));
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
