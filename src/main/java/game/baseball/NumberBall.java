package game.baseball;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class NumberBall {

    public static final int NUMBER_OF_DIGITS = 3;
    public static final int MIN_OF_NUMBER = 1;
    public static final int MAX_OF_NUMBER = 9;

    private final Set<Integer> numbers;

    public NumberBall() {
        numbers = NumberGenerator.shuffleAndGet();
    }

    public NumberBall(String number) {
        checkArgument(number.length() == NUMBER_OF_DIGITS, "길이가 3이어야합니다.");
        checkArgument(number.indexOf('0') == -1, "0이 있네요?");

        numbers = new HashSet<>();
        for (char ch : number.toCharArray()) {
            checkArgument(Character.isDigit(ch), "뭘 입력한거에요?");
            numbers.add(Character.getNumericValue(ch));
        }

        checkArgument(numbers.size() == NUMBER_OF_DIGITS, "중복이 있네요?");
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
