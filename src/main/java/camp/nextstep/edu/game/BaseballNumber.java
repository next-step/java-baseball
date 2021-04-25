package camp.nextstep.edu.game;

import camp.nextstep.edu.util.NumberUtil;
import camp.nextstep.edu.util.ValidationUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    private final List<String> numberList = new ArrayList<>();

    public BaseballNumber(Set<Integer> numberSet) {
        for (Integer integer : numberSet) {
            numberList.add(integer.toString());
        }
    }

    public List<String> getNumberList() {
        return numberList;
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

    public BaseballGameResult compare(String input) {
        return null;
    }
}
