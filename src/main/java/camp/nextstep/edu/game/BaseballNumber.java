package camp.nextstep.edu.game;

import camp.nextstep.edu.util.NumberUtil;
import camp.nextstep.edu.util.ValidationUtil;

import java.util.*;

public class BaseballNumber {

    private final List<String> numberList = new ArrayList<>();

    private BaseballNumber(Set<Integer> numberSet) {
        for (Integer integer : numberSet) {
            numberList.add(integer.toString());
        }
    }

    private BaseballNumber(String numberString) {
        numberList.addAll(Arrays.asList(numberString.split("")));
    }

    public static BaseballNumber of(String input) {
        return new BaseballNumber(input);
    }

    public static BaseballNumber generateBaseballNumber() {
        Set<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < 3) {
            int number = NumberUtil.generateNumber(9) + 1;
            numberSet.add(number);
        }
        return new BaseballNumber(numberSet);
    }

    public static boolean isValidBaseballNumber(String input) {
        return ValidationUtil.isNumber(input)
                && ValidationUtil.isDistinct(input)
                && ValidationUtil.isNotContains(input, "0")
                && input.length() == 3;
    }

    public BaseballGameResult compare(BaseballNumber input) {
        int strike = countStrike(input);
        int ball = countBall(input);
        return new BaseballGameResult(strike, ball);
    }

    private int countStrike(BaseballNumber input) {
        int strike = 0;
        for (int i = 0; i < input.numberList.size(); i++) {
            String targetValue = this.numberList.get(i);
            String inputValue = input.numberList.get(i);
            strike += targetValue.equals(inputValue) ? 1 : 0;
        }
        return strike;
    }

    private int countBall(BaseballNumber input) {
        int ball = 0;
        for (int i = 0; i < input.numberList.size(); i++) {
            String targetValue = this.numberList.get(i);
            String inputValue = input.numberList.get(i);
            ball += (!targetValue.equals(inputValue) && this.numberList.contains(inputValue)) ? 1 : 0;
        }
        return ball;
    }
}
