package baseballgame;

import java.util.Arrays;
import java.util.List;

public class RandomNumber {
    private List<Integer> numbers;

    public RandomNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNumber(int i) {
        return numbers.get(i);
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }
}
