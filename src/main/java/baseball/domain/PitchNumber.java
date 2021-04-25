package baseball.domain;

import java.util.Objects;

public class PitchNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int pitchNumber;

    private PitchNumber(int pitchNumber) {
        validate(pitchNumber);
        this.pitchNumber = pitchNumber;
    }

    public static PitchNumber of(int pitchNumber) {
        return new PitchNumber(pitchNumber);
    }

    public static PitchNumber of(String pitchNumber) {
        return new PitchNumber(Integer.parseInt(pitchNumber.trim()));
    }

    private void validate(int pitchNumber) {
        if (pitchNumber < MIN_NUMBER || pitchNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("1 ~ 9 숫자가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PitchNumber that = (PitchNumber)o;
        return pitchNumber == that.pitchNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitchNumber);
    }
}
