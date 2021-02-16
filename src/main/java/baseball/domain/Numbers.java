package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.pow;

public class Numbers {
    public static final int LOWER_BOUND = 100;
    public static final int DIVEDER = 10;
    private final List<Integer> numbers;
    private final int UPPER_BOUND = 1000;

    // 3 자리 숫자 받음.
    public Numbers(final int number){
        if(LOWER_BOUND > number || number > UPPER_BOUND){
            throw new IllegalArgumentException("세 자리 숫자만 입력 가능합니다.");
        }
        numbers = new ArrayList<>();
        numberToList(number);
    }

    private void numberToList(int number) {
        for(int i=1; i<=2; i++){
            numbers.add((number% DIVEDER));
            number = (number/DIVEDER);
        }
        numbers.add(number);
        Collections.reverse(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
