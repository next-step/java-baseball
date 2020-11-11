package game.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class Number {

    public static final int NUMBER_OF_DIGITS = 3;
    public static final int MIN_OF_NUMBER = 1;
    public static final int MAX_OF_NUMBER = 9;

    private final List<Integer> numbers;

    public Number() {
        numbers = NumberGenerator.shuffleAndGet();
    }

    public Number(String number) {
        checkArgument(number.length() == NUMBER_OF_DIGITS, "길이가 3이어야합니다.");
        checkArgument(number.indexOf('0') == -1, "0이 있네요?");

        Set<Integer> numberSet = new HashSet<>();
        for (char ch : number.toCharArray()) {
            checkArgument(Character.isDigit(ch), "뭘 입력한거에요?");
            numberSet.add(Character.getNumericValue(ch));
        }
        numbers = new ArrayList<>(numberSet);

        checkArgument(numbers.size() == NUMBER_OF_DIGITS, "중복이 있네요?");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
