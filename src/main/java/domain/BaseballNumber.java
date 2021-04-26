package domain;

import utils.UtilMeassage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class BaseballNumber {
    private static final int BASEBALL_MIN_NUM = 1;
    private static final int BASEBALL_MAX_NUM = 9;

    private static final Map<Integer, BaseballNumber> baseballNumber = new HashMap<>();

    static {
        for (int i = BASEBALL_MIN_NUM; i <= BASEBALL_MAX_NUM; i++) {
            baseballNumber.put(i, new BaseballNumber(i));
        }
    }

    private final int number;

    private BaseballNumber(int number) {
        validation(number);
        this.number = number;
    }
    
    public static BaseballNumber of(char number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(UtilMeassage.NULL_EXCEPTION_MESSAGE);
        }

        return of(Integer.parseInt(String.valueOf(number)));
    }

    public static BaseballNumber of(int number) {
        validation(number);
        return Optional.ofNullable(baseballNumber.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    private static void validation(int number) {
        if(number < BASEBALL_MIN_NUM || number > BASEBALL_MAX_NUM) {
            throw new IllegalArgumentException(UtilMeassage.INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE + " ERROR: " + number);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "BaseballNumber{" +
                "number=" + number +
                '}';
    }
}
