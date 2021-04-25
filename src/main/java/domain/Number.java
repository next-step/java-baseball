package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number {
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 9;
    private static final int NUMBER_COUNT = 3;
    private static Map<Integer, Number> numbers = new HashMap<>();
    private final int number;

    static {
        for (int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++) {
            numbers.put(i, new Number(i));
        }
    }

    public Number(int number) {
        this.number = number;
    }

    public static Number of(int number){
        Number num = numbers.get(number);
        if(number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX){
            String message = String.format("유효하지 않은 숫자 범위입니다. (%d ~ %d)", NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
            throw new IllegalArgumentException(message);
        }
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
