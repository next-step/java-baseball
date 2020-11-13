package checkor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballCheckor implements Checkor {

    private final int[] numbers;
    private List<Integer> numberList;
    private Set<Integer> numberSet;

    public BaseballCheckor(int[] numbers) {
        this.numbers = numbers;
        this.numberList = new ArrayList<>();
        this.numberSet = new HashSet<>();

        for (int i=0; i<numbers.length; i++) {
            numberList.add(numbers[i]);
            numberSet.add(numbers[i]);
        }
    }

    @Override
    public String check(int[] input) {
        for (int i : input) numberSet.add(i);
        int strike = strike(input);
        int ball = ball(input, strike);
        return CheckType.printCheckType(strike, ball);
    }

    protected int strike(int[] input) {
        int count = 0;
        for (int i=0; i<input.length; i++) {
            count += numberList.get(i) == input[i] ? 1 : 0;
        }
        return count;
    }

    protected int ball(int[] input, int strike) {
        return (numbers.length + input.length) - strike - numberSet.size();
    }
}
