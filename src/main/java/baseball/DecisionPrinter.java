package baseball;

import custommodel.DecisionResult;

public class DecisionPrinter {
    public void printDecisionResult(DecisionResult decisionResult) {
        if (decisionResult.getNothingCount() == 3) {
            System.out.println("낫싱");

            return;
        }

        this.printHitDecisionCount(decisionResult);
    }

    private void printHitDecisionCount(DecisionResult decisionResult) {
        StringBuilder stringBuilder = new StringBuilder();

        if (decisionResult.getStrikeCount() != 0) {
            stringBuilder.append(decisionResult.getStrikeCount() + " 스트라이크 ");
        }

        if (decisionResult.getBallCount() != 0) {
            stringBuilder.append(decisionResult.getBallCount() + " 볼");
        }
        System.out.println(stringBuilder.toString());
    }
}
