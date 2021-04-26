package baseball.view;

import java.util.Map;

import static baseball.constant.Constant.*;

public class ResultView {
    public boolean printBaseBall(Map<String, Integer> swing) {
        boolean gameEnd = false;
        StringBuilder sb = new StringBuilder();
        if (swing.get(STRIKE) > 0) {
            sb.append(swing.get(STRIKE) + "스트라이크");
        }
        if (swing.get(BALL) > 0) {
            sb.append((sb.length() > 0) ? " " + swing.get(BALL) + "볼" : swing.get(BALL) + "볼");
        }
        if ( (swing.get(STRIKE) + swing.get(BALL)) == NOTHING) {
            sb.append(NOTHING_STRING);
        }
        if (swing.get(STRIKE) == GAME_END) {
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameEnd = true;
        }
        System.out.println(sb.toString());
        return gameEnd;
    }
}
