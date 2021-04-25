package baseball.view;

import java.util.List;

public class ResultView {
    public void printBaseBall(List<Integer> swing) {
        StringBuilder sb = new StringBuilder();
        if (swing.get(0) > 0) {
            sb.append(swing.get(0) + "스트라이크");
        }
        if (swing.get(1) > 0) {
            sb.append((sb.length() > 0) ? " " + swing.get(1) + "볼" : swing.get(1) + "볼");
        }
        if (swing.get(0) == 0 && swing.get(1) == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }
}
