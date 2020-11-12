package nextstep.precourse.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumbers {
    public static final String BALLNUMBERS_COUNT_INVALID_MESSAGE = "숫자는 3개를 제시해주세요";
    public static final String BALLNUMBERS_POSITION_INVALID_MESSAGE = "숫자들은 서로 다른 포지션에 포진되어 있어야 합니다.";
    public static final String BALLNUMBERS_NUMBER_INVALID_MESSAGE = "서로 다른 숫자를 제시해주세요.";
    private List<BallNumber> ballNumbers;

    public BallNumbers(List<BallNumber> ballNumbers) {
        assertCount(ballNumbers);
        assertPosition(ballNumbers);
        assertNumber(ballNumbers);

        this.ballNumbers = ballNumbers;
    }

    public Integer getNumberByPosition(int position) {

        for(BallNumber ballNumber : ballNumbers) {
            if(ballNumber.isPosition(position)) {
                return ballNumber.getNumber();          //TODO: Depth Refactoring
            }
        }
        return null;
    }

    public BallNumber getBallNumberByPosition(int position) {

        for(BallNumber ballNumber : ballNumbers) {
            if(ballNumber.isPosition(position)) {       //TODO: Depth Refactoring
                return ballNumber;
            }
        }
        return null;
    }

    public boolean isSameNumberAtPosition(BallNumbers target, int position) {
        return getBallNumberByPosition(position).isSameNumber(target.getBallNumberByPosition(position));
    }

    public boolean isContain(Integer number) {
        for(BallNumber ballNumber : ballNumbers) {
            if(ballNumber.isNumber(number)) {           //TODO: Depth Refactoring
                return true;
            }
        }
        return false;
    }

    private void assertCount(List<BallNumber> ballNumbers) {
        if(ballNumbers.size() != 3) {
            throw new IllegalArgumentException(BALLNUMBERS_COUNT_INVALID_MESSAGE);
        }
    }

    private void assertPosition(List<BallNumber> ballNumbers) {
        Set<Integer> positionSet = new HashSet<>();

        for(BallNumber ballNumber : ballNumbers) {
            positionSet.add(ballNumber.getPosition());
        }

        if(positionSet.size() != 3) {
            throw new IllegalArgumentException(BALLNUMBERS_POSITION_INVALID_MESSAGE);
        }
    }

    private void assertNumber(List<BallNumber> ballNumbers) {
        Set<Integer> numberSet = new HashSet<>();

        for(BallNumber ballNumber : ballNumbers) {
            numberSet.add(ballNumber.getNumber());
        }

        if(numberSet.size() != 3) {
            throw new IllegalArgumentException(BALLNUMBERS_NUMBER_INVALID_MESSAGE);
        }
    }
}
