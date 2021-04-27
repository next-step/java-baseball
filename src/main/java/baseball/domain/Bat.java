package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Bat {
    private static final String INPUT_WITHOUT_DUPLICATE = "중복 없이 숫자를 3개 입력해주세요.";
    private static int MAX_BALL_COUNT = 3;

    private List<BallNumber> shot;

    public Bat() {
        this(new ArrayList<>());
    }

    public Bat(List<BallNumber> shot) {
        this.shot = shot;
    }

    public void addShot(BallNumber ballNumber) {
        if (shot.contains(ballNumber)) {
            throw new IllegalArgumentException(INPUT_WITHOUT_DUPLICATE);
        }
        if (shot.size() >= MAX_BALL_COUNT) {
            throw new IllegalArgumentException(INPUT_WITHOUT_DUPLICATE);
        }
        shot.add(ballNumber);
    }

    public List<BallNumber> getShots() {
        return new ArrayList<>(shot);
    }
}
