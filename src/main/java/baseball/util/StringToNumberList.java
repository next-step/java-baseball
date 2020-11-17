package baseball.util;

import baseball.model.Numbers;
import baseball.model.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToNumberList {

    private static final String LOTTO_NUMBER_SEPARATOR = "";

    private StringToNumberList() {
    }

    public static Numbers transform(final String stringNumbers) {
        List<Number> numbers = new ArrayList<>();

        String[] splitNumber = splitNumber(stringNumbers);

        for(String s : splitNumber) {
            numbers.add(new Number(s));
        }

        return new Numbers(numbers);
    }

    private static String[] splitNumber(final String winningLottoNumber) {
        return winningLottoNumber.split(LOTTO_NUMBER_SEPARATOR);
    }

}
