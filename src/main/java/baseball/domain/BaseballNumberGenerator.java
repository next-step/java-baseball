package baseball.domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator {
    private SecureRandom secureRandom = new SecureRandom();

    public BaseballNumberGroup generate() {
        List<Integer> baseballNumbers = generateRandomNumbers();
        return BaseballNumberGroup.of(baseballNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < GameRule.NUMBER_OF_DIGITS) {
            Integer number = secureRandom.nextInt(GameRule.END_NUMBER) + 1;
            addNumber(number, baseballNumbers);
        }
        return baseballNumbers;
    }

    private void addNumber(Integer number, List<Integer> baseballNumbers) {
        if (baseballNumbers.contains(number)) {
            return;
        }
        baseballNumbers.add(number);
    }
}
