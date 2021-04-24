package baseball.domain;

public class Player {
    private final PitchNumbers pitchNumbers;
    private PitchResult pitchResult;

    private Player(PitchNumbers pitchNumbers) {
        this.pitchNumbers = pitchNumbers;
    }

    public static Player of(String numbers) {
        return new Player(PitchNumbers.of(numbers));
    }

    public static Player of(PitchNumbers PitchNumbers) {
        return new Player(PitchNumbers);
    }

    public void play(String numbers) {
    }

    public boolean isFinished() {
        return pitchResult.isFinished();
    }
}
