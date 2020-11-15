package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

import java.util.List;

public abstract class FilteredRule implements JudgeRule {

    private final List<JudgeRule> excludeRules;

    FilteredRule(final JudgeRule... excludeRules) {
        this(List.of(excludeRules));
    }

    FilteredRule(final List<JudgeRule> excludeRules) {
        this.excludeRules = excludeRules;
    }

    abstract boolean filteredJudge(Balls balls, Balls other, int index);

    @Override
    public boolean judges(final Balls balls,
                          final Balls other,
                          final int index) {
        if (isFiltered(balls, other, index)) {
            return false;
        }

        return filteredJudge(balls, other, index);
    }

    private boolean isFiltered(final Balls balls,
                               final Balls other,
                               final int index) {
        var filtered = false;
        for (final var rule : excludeRules) {
            filtered |= rule.judges(balls, other, index);
        }

        return filtered;
    }
}
