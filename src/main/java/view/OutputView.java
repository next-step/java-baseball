package view;

import java.util.List;

public class OutputView {

    public static final String DELIMITER = " ";
    public static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";

    public void showResult(List<String> result) {
        System.out.println(String.join(DELIMITER, result));
    }

    public void printFinishRound() {
        System.out.println(FINISH_MESSAGE);
    }
}
