package baseball;

import java.util.ArrayList;
import java.util.List;

import customtypes.Decision;

public class BaseballReferee {
    public List<Decision> decide(char[] tryBalls, String matchTarget) {
        List<Decision> decisions = new ArrayList<>();

        for (int i = 0; i < tryBalls.length; i++) {
            Decision decision = this.decide(tryBalls[i], i, matchTarget);

            decisions.add(decision);
        }

        return decisions;
    }

    private Decision decide(char tryBall, int ballIndex, String matchTarget) {
        int matchedIdx = matchTarget.indexOf(tryBall);

        if (matchedIdx == -1) { return Decision.NOTHING; }
        if (matchedIdx == ballIndex) { return Decision.STRIKE; }

        return Decision.BALL;
    }
}
