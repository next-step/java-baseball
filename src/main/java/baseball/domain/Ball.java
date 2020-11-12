package baseball.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Ball {
    private static final String NUMBER_RANGE_REX = "[1-9]";
    private String number;
    private int order;

    public Ball(String number, int order) {
        validate(number, order);
        this.number = number;
        this.order = order;
    }

    private void validate(String number, int order) {
        if (!Pattern.matches(NUMBER_RANGE_REX, number)) {
            throw new IllegalArgumentException("1-9 사이 값을 입력해주세요");
        }

        if (order < 0 || order > 2) {
            throw new IllegalArgumentException("순서값이 잘못됐습니다.");
        }
    }

    public Matcher compare(Ball ball) {
        if (!this.number.equals(ball.number)) {
            return Matcher.find(-1);
        }

        return this.order == ball.order ? Matcher.find(1) : Matcher.find(0);
    }
}
