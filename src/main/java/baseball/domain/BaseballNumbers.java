package baseball.domain;
import baseball.exception.DuplicationException;
import baseball.exception.NumberDigitException;
import baseball.exception.NumberZeroException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private final List<Integer> baseballNumbers;

    public BaseballNumbers(List<Integer> numbers) {

        if (numbers.size() != 3) throw new NumberDigitException();

        if (numbers.contains(0)) throw new NumberZeroException();

        if (isDuplicate(numbers)) throw new DuplicationException();

        this.baseballNumbers = numbers;
    }

    public boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return (set.size() < 3);
    }

    public int get(int i) {
        return this.baseballNumbers.get(i);
    }

    public int size() {
        return this.baseballNumbers.size();
    }

    public boolean contains(int number) {
        return this.baseballNumbers.contains(number);
    }

    public boolean equalsNumberAndIndex(int index, int number) {
        return this.baseballNumbers.get(index) == number;
    }

}
