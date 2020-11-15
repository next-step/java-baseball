package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputNumber {
    List<Integer> numbers;

    public InputNumber() {
    }

    public InputNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumber number = (InputNumber) o;
        return Objects.equals(numbers, number.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public InputNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        for(String number : input.split("")) {
            numbers.add(Integer.parseInt(number));
        }
        this.numbers = numbers;
    }

    public Integer size() {
        return numbers.size();
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }
}
