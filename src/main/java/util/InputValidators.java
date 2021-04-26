package util;

import common.Const;

import java.util.ArrayList;
import java.util.List;

public class InputValidators {

    private String inputNumber = "";

    public InputValidators(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public List<Integer> convert() {
        List<Integer> inputNumbers = new ArrayList<>();

        validators();

        for (int i = 0; i < Const.INPUT_NUMBER_SIZE; i++) {
            inputNumbers.add(inputNumber.charAt(i) - '0');
        }
        return inputNumbers;
    }

    public void validators() {
        if (inputNumber.length() > Const.INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리를 입력해주세요");
        }
    }
}
