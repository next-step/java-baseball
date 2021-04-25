package baseball.view;

import java.util.List;
import java.util.Map;

import static baseball.constant.Constant.BALL;
import static baseball.constant.Constant.STRIKE;

public class ResultView {
    public void printBaseBall(Map<String, Integer> swing) {
        StringBuilder sb = new StringBuilder();
        if (swing.get(STRIKE) > 0) {
            sb.append(swing.get(STRIKE) + "스트라이크");
        }
        if (swing.get(BALL) > 0) {
            sb.append((sb.length() > 0) ? " " + swing.get(BALL) + "볼" : swing.get(BALL) + "볼");
        }
        if ( (swing.get(STRIKE) + swing.get(BALL)) == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }
}
