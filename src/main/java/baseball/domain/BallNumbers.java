package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 공의 숫자 모음.
 */
public class BallNumbers {
    private static final String INPUT_WITHOUT_DUPLICATE = "중복 없이 숫자를 3개 입력해주세요.";
    private static int MAX_BALL_COUNT = 3;

    private Set<BallNumber> ballNumbers;

    public BallNumbers(List<BallNumber> ballNumbers) {
        this.ballNumbers = validate(ballNumbers);
    }

    private Set<BallNumber> validate(List<BallNumber> ballNumbers) {
        final Set<BallNumber> set = new HashSet<>();
        for (BallNumber ballNumber : ballNumbers) {
            set.add(ballNumber);
        }
        if (set.size() != MAX_BALL_COUNT) {
            throw new IllegalArgumentException(INPUT_WITHOUT_DUPLICATE);
        }
        return new LinkedHashSet<>(ballNumbers);
    }

    public List<BallNumber> getBallNumbers() {
        return new ArrayList<>(ballNumbers);
    }

    public int getSize() {
        return ballNumbers.size();
    }
}
