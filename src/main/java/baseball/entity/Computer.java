package baseball.entity;

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
        if (selectNumber.length() != 3 || duplicateCheckNumberLength(selectNumber) != 3) {
            throw new IllegalArgumentException("서로 다른 임의의 수 3개만 선택 가능 합니다.");
        }
    }

    private int duplicateCheckNumberLength(String selectNumber) {
        Set<Character> lengthCheckSet = new HashSet<>();

        for (int i = 0; i < selectNumber.length(); i++) {
            lengthCheckSet.add(selectNumber.charAt(i));
        }

        return lengthCheckSet.size();
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
