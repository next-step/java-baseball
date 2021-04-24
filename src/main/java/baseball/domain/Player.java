package baseball.domain;

import java.util.Objects;

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
        PitchNumbers comparePitchNumbers = PitchNumbers.of(numbers);
        int strikeCount = pitchNumbers.matchStrike(comparePitchNumbers);
        int ballCount = pitchNumbers.matchBall(comparePitchNumbers);
        pitchResult = PitchResult.of(strikeCount, ballCount);
    }

    public boolean isFinished() {
        return pitchResult.isFinished();
    }

    public PitchResult result() {
        return this.pitchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player)o;
        return Objects.equals(pitchNumbers, player.pitchNumbers) && Objects.equals(pitchResult,
            player.pitchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitchNumbers, pitchResult);
    }
}
