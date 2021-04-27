package baseball;

import java.util.List;

import custommodel.DecisionResult;
import customtypes.Decision;

public class DecisionCounter {
    public DecisionResult countDecisions(List<Decision> decisions) {
        DecisionResult decisionResult = new DecisionResult();

        for (Decision decision : decisions) {
            this.countDecision(decision, decisionResult);
        }

        return decisionResult;
    }

    private void countDecision(Decision decision, DecisionResult decisionResult) {
        if (decision == Decision.STRIKE) { decisionResult.addStrikeCount(); }

        if (decision == Decision.BALL) { decisionResult.addBallCount(); }

        if (decision == Decision.NOTHING) { decisionResult.addNothingCount(); }
    }
}
