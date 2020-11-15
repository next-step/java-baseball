package baseballgame;

import java.util.List;

public class RandomNumber {
    private List<Integer> numbers;

    public RandomNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNumber(int i) {
        return numbers.get(i);
    }
}
