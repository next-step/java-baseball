package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Ball {
    private static final String INPUT_WITHOUT_DUPLICATE = "중복 없이 숫자를 3개 입력해주세요.";
    private static int MAX_BALL_COUNT = 3;
    private final Set<BallNumber> ballNumbers;

    public Ball(List<BallNumber> ballNumbers) {
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

    public int getMatchCount(Bat bat) {
        List<BallNumber> shots = bat.getShots();
        List<BallNumber> ballList = getBallList();
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < shots.size(); i++) {
            BallNumber shot = shots.get(i);
            BallNumber generated = ballList.get(i);

            strikeCount = getMatchCount(strikeCount, shot, generated);
        }

        return strikeCount;
    }

    private int getMatchCount(int matchCount, BallNumber shot, BallNumber generated) {
        if (shot.equals(generated)) {
            matchCount++;
        }
        if (!shot.equals(generated) && isBallNumberMatch(shot)) {
            // TODO : 점수 계산기에서 점수 계산
        }

        return matchCount;
    }

    private boolean isBallNumberMatch(BallNumber ballNumber) {
        return ballNumbers.contains(ballNumber);
    }

    public Set<BallNumber> getBallNumbers() {
        return ballNumbers;
    }

    public List<BallNumber> getBallList() {
        return new ArrayList<>(ballNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballNumbers, ball.ballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(ballNumbers);
    }
}
