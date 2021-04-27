package baseballgame.game;

import java.util.List;

public class GameResult {

    private final Hint hint;

    public GameResult(Hint hint) {
        this.hint = hint;
    }

    public static GameResult of(List<MatchResult> matchResultList) {
        return new GameResult(Hint.create(matchResultList));
    }

    public String printHint() {
        return hint.getMessage();
    }

    public boolean isAnswer() {
        return hint.isThreeStrike();
    }
}
