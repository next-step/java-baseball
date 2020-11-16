package baseball;

import java.util.List;

public class Play {

    private final Pitches pitches;


    private Play(List<Integer> target, List<Integer> trial) {
        this.pitches = Pitches.of(trial, target);
    }

    public static Play of(Target target, Trial trial) {
        return Play.of(target.value, trial.value);
    }

    public static Play of(List<Integer> target, List<Integer> trial) {
        return new Play(target, trial);
    }

    public boolean hasWin() {
        return pitches.strikeCount() == 3;
    }

    public String getHint() {
        String hint = "";
        hint = getHintStrike(hint);
        hint = getHintBall(hint);
        return hint.equals("")
               ? "낫싱"
               : hint;
    }

    private String getHintStrike(String hint) {
        return pitches.hasStrike()
               ? hint + pitches.strikeCount() + " 스트라이크 "
               : hint;
    }

    private String getHintBall(String hint) {
        return pitches.hasBall()
               ? hint + pitches.ballCount() + " 볼 "
               : hint;
    }
}
