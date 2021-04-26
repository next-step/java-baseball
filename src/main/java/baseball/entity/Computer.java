package baseball.entity;

import baseball.util.ValidateNumberUtil;

import java.util.Objects;

public class Computer {
    private final String selectNumber;

    public Computer(String selectNumber) {
        validateLength(selectNumber);
        this.selectNumber = selectNumber;
    }

    private void validateLength(String selectNumber) {
        if (!ValidateNumberUtil.validateNumber(selectNumber)) {
            throw new IllegalArgumentException("서로 다른 임의의 수 3개만 선택 가능 합니다.");
        }
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
