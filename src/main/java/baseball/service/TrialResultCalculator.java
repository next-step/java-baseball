package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameNumberPackage;
import baseball.domain.InputNumbers;
import baseball.domain.NumberResult;

import java.util.HashMap;
import java.util.Map;

import static baseball.domain.NumberResult.*;

public class TrialResultCalculator {
    private final Map<NumberResult, Integer> trialResults = new HashMap<>();

    public TrialResultCalculator(GameNumberPackage gameNumberPackage, InputNumbers inputNumbers) {
        for (int i = 0; i < inputNumbers.size(); ++i) {
            NumberResult numberResult = getNumberResult(gameNumberPackage, inputNumbers.get(i), i);
            trialResults.merge(numberResult, 1, (oldValue, initValue) -> oldValue + 1);
        }
    }

    private NumberResult getNumberResult(
        GameNumberPackage gameNumberPackage,
        GameNumber curInputNumber,
        int curNumberIndex
    ) {
        if (!gameNumberPackage.containsGameNumber(curInputNumber)) {
            return OUT;
        }

        int numberIndex = gameNumberPackage.getGameNumberIndex(curInputNumber);
        if (numberIndex == curNumberIndex) {
            return STRIKE;
        }

        return BALL;
    }

    public int getOrDefault(NumberResult numberResult, int defaultValue) {
        return trialResults.getOrDefault(numberResult, defaultValue);
    }
}
