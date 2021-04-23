package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBallGame {
    private String answer;

    public void start() {
        initializeAnswer();
        playUntilCorrect();
    }

    void initializeAnswer() {
        List<String> list = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
        Collections.shuffle(list);

        this.answer = String.join(list.get(0), list.get(1), list.get(2));
    }

    void playUntilCorrect() {
        while (true) {
            if (isCorrect(UserInterface.printGuideAndScanUserInput())) {
                UserInterface.printGameComplete();
                break;
            }
        }
    }

    String getAnswer() {
        return answer;
    }

    boolean isCorrect(String guess) {
        return answer.equals(guess);
    }
}
