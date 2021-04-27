package baseball;

import java.util.function.Function;
import java.util.function.Predicate;

public class BaseballResultPrinter {
    public void printResult(BaseballRule rule) {
        for (BaseballResult ballCountPrinter : BaseballResult.values()) {
            ballCountPrinter.checkResult(ballCountPrinter, rule);
        }
    }

    private enum BaseballResult {
        STRIKE((baseballRule) -> baseballRule.getStrike() > 0 && baseballRule.getBall() == 0,
                (baseballRule) -> baseballRule.getStrike() + " 스트라이크"),
        BALL((baseballRule) -> baseballRule.getStrike() == 0 && baseballRule.getBall() > 0,
                (baseballRule) -> baseballRule.getBall() + " 볼"),
        STRIKE_AND_BALL((baseballRule) -> baseballRule.getStrike() > 0 && baseballRule.getBall() > 0,
                (baseballRule) -> baseballRule.getStrike() + " 스트라이크 " + baseballRule.getBall() + " 볼"),
        NOTHING((baseballRule) -> baseballRule.getStrike() == 0 && baseballRule.getBall() == 0,
                (baseballRule) -> "낫싱");

        private Predicate<BaseballRule> predicate;
        private Function<BaseballRule, String> function;

        BaseballResult(Predicate<BaseballRule> predicate, Function<BaseballRule, String> function) {
            this.predicate = predicate;
            this.function = function;
        }

        private void checkResult(BaseballResult baseballResult, BaseballRule baseballRule) {
            if (baseballResult.predicate.test(baseballRule)) {
                System.out.println(function.apply(baseballRule));
            }
        }
    }
}

