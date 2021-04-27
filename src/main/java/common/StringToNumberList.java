package common;

import java.util.ArrayList;
import java.util.List;

import model.Numbers;
import model.Number;

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
