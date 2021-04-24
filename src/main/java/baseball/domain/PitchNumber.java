package baseball.domain;

public class PitchNumber {
    private final int pitchNumber;

    private PitchNumber(int pitchNumber) {
        this.pitchNumber = pitchNumber;
    }

    public static PitchNumber of(int pitchNumber) {
        return new PitchNumber(pitchNumber);
    }
}
