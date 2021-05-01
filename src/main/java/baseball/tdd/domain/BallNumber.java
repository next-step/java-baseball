package baseball.tdd.domain;

public class BallNumber {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    private int no;

    public BallNumber(int  no) {
        if (no < MIN_NO || no > MAX_NO){
            throw new IllegalArgumentException("볼 숫자는 1부터 9까지의 값이어야 합니다.");
        }
        this.no = no;
    }
}
