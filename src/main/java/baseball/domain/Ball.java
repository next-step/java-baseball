package baseball.domain;

public class Ball {
    private int number;
    private int order;

    public Ball(int number, int order) {
        validate(number, order);
        this.number = number;
        this.order = order;
    }

    private void validate(int number, int order) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1-9 사이 값을 입력해주세요");
        }

        if (order < 0 || order > 2) {
            throw new IllegalArgumentException("순서값이 잘못됐습니다.");
        }
    }

    public Matcher compare(Ball ball) {
        if (this.number != ball.number) {
            return Matcher.find(-1);
        }

        return this.order == ball.order ? Matcher.find(1) : Matcher.find(0);
    }
}
