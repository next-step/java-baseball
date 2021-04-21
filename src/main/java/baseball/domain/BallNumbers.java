package baseball.domain;

import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.domain.PitchingResultStatus.*;

public class BallNumbers {

    private final List<BallNumber> ballNumbers = new ArrayList<>();

    public BallNumbers(List<BallNumber> ballNumbers) {
        checkSize(ballNumbers);
        for (BallNumber ballNumber : ballNumbers) {
            checkDuplicate(ballNumber);
            this.ballNumbers.add(ballNumber);
        }
    }

    private void checkSize(List<BallNumber> ballNumbers) {
        if (ballNumbers.size() != 3) {
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
        if (ballNumbers.get(index).equals(ballNumber)) {
            return STRIKE;
        }
        if (ballNumbers.contains(ballNumber)) {
            return BALL;
        }
        return NOTHING;
    }
}
