package me.kingcjy.baseball.ball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author KingCjy
 */
public class BallGenerator {

    private Random random = new Random();

    public Ball generate(int digit) {
        Set<Integer> numbers = generateNumberSet(digit);
        int[] numberArray = setToIntArray(numbers);

        return new Ball(numberArray);
    }

    private Set<Integer> generateNumberSet(int digit) {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < digit) {
            numbers.add(random.nextInt(9) + 1);
        }

        return numbers;
    }

    private int[] setToIntArray(Set<Integer> numbers) {
        int[] result = new int[numbers.size()];

        int i = 0;
        for (Integer number : numbers) {
            result[i] = number;
            i++;
        }

        return result;
    }
}
