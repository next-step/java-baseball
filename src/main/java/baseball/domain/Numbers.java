package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Numbers {
    public static final int NUMBER_LENGTH = 3;
    private List<Integer> numbers;

    // 3 자리 숫자 받음.
    public Numbers(final String number){
        if(number.length() != NUMBER_LENGTH){
            throw new IllegalArgumentException("세 자리 숫자만 입력 가능합니다.");
        }
        numberToList(number);
    }

    private void numberToList(String number) {
        numbers = Arrays.stream(number.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
