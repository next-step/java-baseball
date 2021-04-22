package domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final int MINIMUM_NUMBERS_VALUE = 100;
    private static final int MAXIMUM_NUMBERS_VALUE = 999;
    private static final int COUNT_OF_NUMBERS = 3;

    private final List<Integer> list;

    public Numbers(int numbers) {
        validateNumbers(numbers);
        this.list = new ArrayList<>(3);
        String str = String.valueOf(numbers);

        for (int i = 0; i < str.length(); i++) {
            list.add(charToInt(str.charAt(i)));
        }
    }

    private int charToInt(char c) {
        return c - '0';
    }

    public Numbers(List<Integer> list) {
        validateList(list);
        this.list = list;
    }

    private void validateNumbers(int numbers) {
        if (numbers < MINIMUM_NUMBERS_VALUE || numbers > MAXIMUM_NUMBERS_VALUE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    private void validateList(List<Integer> list) {
        if (list.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    public int get(int index) {
        return list.get(index);
    }

    public boolean contains(int number) {
        return list.contains(number);
    }
}
