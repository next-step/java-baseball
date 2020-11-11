package nextstep.precourse.domain;

public class BallNumber {

    public static final String BALLNUMBER_NUMBER_INVALID_MESSAGE = "1에서 9사이의 숫자여야 합니다.";
    public static final String BALLNUMBER_POSITION_INVALID_MESSAGE = "숫자의 위치는 1,2,3 중 하나여야 합니다.";

    private int number;
    private int position;

    public BallNumber(int number, int position) {
        assertNumber(number);
        assertPosition(position);

        this.number = number;
        this.position = position;
    }

    private void assertNumber(int number) {
        if(number > 9 || number < 1) {
            throw new IllegalArgumentException(BALLNUMBER_NUMBER_INVALID_MESSAGE);
        }
    }

    private void assertPosition(int position) {
        if(position < 1 || position > 3) {
            throw new IllegalArgumentException(BALLNUMBER_POSITION_INVALID_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

}
