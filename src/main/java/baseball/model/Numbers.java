package baseball.model;

import baseball.exception.EmptyNumberException;
import baseball.exception.InvalidCountOfNumberException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    public static final int COUNT_OF_NUMBER = 3;

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        if (Objects.isNull(numbers)) {
            throw new EmptyNumberException();
        }

        if(numbers.size() != COUNT_OF_NUMBER) {
            throw new InvalidCountOfNumberException(numbers.size());
        }

        this.numbers = numbers.stream()
                .collect(Collectors.toList());
    }

    int countSamPosiAndNum(final Numbers comparisonTarget) {
        int strike = 0;

        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i).compareTo(comparisonTarget.numbers.get(i)) == 0) {
                strike++;
            }
        }

        return strike;
    }

    int countSamNum(final Numbers comparisonTarget) {
        int count = 0;

        for(Number n :  numbers) {
            if(comparisonTarget.numbers.contains(n)) {
                count++;
            }
        }

        return count;
    }
}
