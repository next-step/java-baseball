package game.baseball.number.participants.evaluators;

import static game.baseball.number.exceptions.ExceptionCodes.SUPPRESS_INSTANCE;

public final class Evaluators {

    private Evaluators() {
        throw new AssertionError(SUPPRESS_INSTANCE);
    }

    public static Evaluator strikeEvaluator() {
        return new StrikeEvaluator();
    }

    public static Evaluator ballEvaluator() {
        return new BallEvaluator();
    }
}
