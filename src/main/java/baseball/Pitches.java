package baseball;

import java.util.List;

import static baseball.PitchResult.BALL;
import static baseball.PitchResult.STRIKE;

public class Pitches {

    static final int FIRST_TRY = 0;
    static final int SECOND_TRY = 1;
    static final int THIRD_TRY = 2;
    final Pitch first;
    final Pitch second;
    final Pitch third;

    private Pitches(Pitch first, Pitch second, Pitch third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static Pitches of(List<Integer> target, List<Integer> trial) {
        return new Pitches(Pitch.of(FIRST_TRY, trial, target),
                           Pitch.of(SECOND_TRY, trial, target),
                           Pitch.of(THIRD_TRY, trial, target));
    }

    public int strikeCount() {
        return getCount(STRIKE);
    }

    public int ballCount() {
        return getCount(BALL);
    }

    public boolean hasStrike() {
        return strikeCount() > 0;
    }

    public boolean hasBall() {
        return ballCount() > 0;
    }

    private int getCount(PitchResult r) {
        int cnt = 0;
        cnt += (first.result == r ? 1 : 0);
        cnt += (second.result == r ? 1 : 0);
        cnt += (third.result == r ? 1 : 0);
        return cnt;
    }
}
