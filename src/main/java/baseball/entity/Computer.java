package baseball.entity;

import baseball.model.CompareResult;
import baseball.util.ValidateNumberUtil;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Computer {

    private final String selectNumber;

    public Computer(String selectNumber) {
        validateLength(selectNumber);
        this.selectNumber = selectNumber;
    }

    private void validateLength(String selectNumber) {
        if (ValidateNumberUtil.validateNumber(selectNumber)) {
            throw new IllegalArgumentException("서로 다른 임의의 수 3개만 선택 가능 합니다.");
        }
    }

    public CompareResult compareNumber(String inputNumber) {
        Set<Character> inputNumberSet = new HashSet<>();
        int strike = 0;
        int totalSameCount = 0;

        for (int i = 0; i < selectNumber.length(); i++) {
            strike += strikeCount(inputNumber, i);
            inputNumberSet.add(inputNumber.charAt(i));
        }

        for (int i = 0; i < selectNumber.length(); i++) {
            totalSameCount += totalSameCount(inputNumberSet, i);
        }

        return new CompareResult(strike, totalSameCount - strike);
    }

    private int strikeCount(String inputNumber, int index) {
        if (selectNumber.charAt(index) == inputNumber.charAt(index)) {
            return 1;
        }
        return 0;
    }

    private int totalSameCount(Set<Character> inputNumberSet, int index) {
        if (inputNumberSet.contains(selectNumber.charAt(index))) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(selectNumber, computer.selectNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectNumber);
    }
}
