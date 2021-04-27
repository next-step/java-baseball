package baseball.domain;

import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.domain.PitchingResultStatus.*;

public class BallNumbers {

    public static final int VALID_EXACT_SIZE = 3;
    private final List<BallNumber> ballNumbers = new ArrayList<>();

    public BallNumbers(List<BallNumber> ballNumbers) {
        checkSize(ballNumbers);
        for (BallNumber ballNumber : ballNumbers) {
            checkDuplicate(ballNumber);
            this.ballNumbers.add(ballNumber);
        }
    }

    public static BallNumbers of(List<Integer> inputNumbers) {
        List<BallNumber> ballNumbers = new ArrayList<>();
        for (Integer number : inputNumbers) {
            ballNumbers.add(new BallNumber(number));
        }
        return new BallNumbers(ballNumbers);
    }

    private void checkSize(List<BallNumber> ballNumbers) {
        if (ballNumbers.size() != VALID_EXACT_SIZE) {
            throw new InvalidBallNumbersSizeException();
        }
    }

    private void checkDuplicate(BallNumber ballNumber) {
        if (this.ballNumbers.contains(ballNumber)) {
            throw new DuplicateBallNumberException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumbers)) return false;
        BallNumbers that = (BallNumbers) o;
        return Objects.equals(ballNumbers, that.ballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumbers);
    }

    public boolean containsAll(List<BallNumber> ballNumbers) {
        return this.ballNumbers.containsAll(ballNumbers);
    }

    public BallNumber get(int index) {
        return ballNumbers.get(index);
    }

    public int size() {
        return ballNumbers.size();
    }

    public PitchingResultStatus getPitchingResultStatus(BallNumber ballNumber, int index) {
        if (isStrike(ballNumber, index)) {
            return STRIKE;
        }
        if (isBall(ballNumber)) {
            return BALL;
        }
        return NOTHING;
    }

    private boolean isBall(BallNumber ballNumber) {
        return ballNumbers.contains(ballNumber);
    }

    private boolean isStrike(BallNumber ballNumber, int index) {
        return ballNumbers.get(index).equals(ballNumber);
    }
}
