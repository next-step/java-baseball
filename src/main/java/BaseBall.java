import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBall {
    private static final List<Integer> DEFAULT_RANGE = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final int DEFAULT_LENGTH = 3;

    private List<Integer> answer;

    public BaseBall() {
        this.answer = makeAnswer();
    }

    public BaseBall(List<Integer> answer) {
        this.answer = answer;
    }

    public static List<Integer> makeAnswer() {
        List<Integer> copy = new ArrayList<>(DEFAULT_RANGE);
        Collections.shuffle(copy);
        return copy.subList(0, DEFAULT_LENGTH);
    }

    public boolean isAnswer(List<Integer> userAnswer) {
        int strike = getStrike(userAnswer);
        int ball = getBall(userAnswer) - strike;

        System.out.println(resultMessage(strike, ball));
        if (strike == DEFAULT_LENGTH) {
            System.out.println(DEFAULT_LENGTH + "개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private String resultMessage(int strike, int ball) {
        StringBuilder message = new StringBuilder();

        if (strike + ball < 1) {
            message.append("일치하는 숫자가 존재하지 않습니다.");
            return message.toString();
        }
        if (strike > 0) message.append(strike + " 스트라이크 ");
        if (ball > 0) message.append(ball + " 볼");

        return message.toString().trim();
    }

    private int getBall(List<Integer> userAnswer) {
        int ball = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (answer.contains(userAnswer.get(i))) ++ball;
        }

        return ball;
    }

    private int getStrike(List<Integer> userAnswer) {
        int strike = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (answer.get(i).equals(userAnswer.get(i))) ++strike;
        }

        return strike;
    }
}
