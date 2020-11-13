package checkor;

import java.util.*;

public class BaseballCheckor implements Checkor<Boolean> {

    private final int[] numbers;
    private List<Integer> numberList;
    private Set<Integer> numberSet;

    public BaseballCheckor(int[] input) {
        this.numbers = input;
        this.numberList = new ArrayList<>();

        for (int i=0; i<numbers.length; i++) {
            numberList.add(numbers[i]);
        }
    }

    @Override
    public Boolean check(String input) {
        int[] inputArr = stringToIntArr(input);
        initSet(inputArr);
        int strike = strike(inputArr);
        int ball = ball(inputArr, strike);
        System.out.println(CheckType.printCheckType(strike, ball));
        return strike == 3 ? Boolean.TRUE : Boolean.FALSE;
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

    protected void initSet(int[] input) {
        numberSet = new HashSet<>();
        for (int i=0; i<input.length; i++) {
            numberSet.add(numbers[i]);
            numberSet.add(input[i]);
        }
    }
}
