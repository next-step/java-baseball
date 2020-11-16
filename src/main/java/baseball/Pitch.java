package baseball;

import java.util.List;
import java.util.Objects;

import static baseball.PitchResult.BALL;
import static baseball.PitchResult.NOTHING;
import static baseball.PitchResult.STRIKE;

public final class Pitch {

    final PitchResult result;

    public Pitch(PitchResult result) {
        this.result = result;
    }

    public static Pitch of(Integer idx, List<Integer> trial, List<Integer> target) {
        if (Objects.equals(trial.get(idx), target.get(idx))) {
            return new Pitch(STRIKE);
        }
        if (target.contains(trial.get(idx))) {
            return new Pitch(BALL);
        }
        return new Pitch(NOTHING);
    }
}
