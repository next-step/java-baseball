package com.ssabae.woowahantech.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class NumberRangeValidator implements Validator<List<Integer>> {

    private final int minValue;
    private final int maxValue;

    protected NumberRangeValidator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean validate(List<Integer> gameNumbers) {
        if (gameNumbers == null || gameNumbers.isEmpty()) {
            return false;
        }
        List<Integer> copyGameNumbers = new ArrayList<>(gameNumbers);
        Collections.sort(copyGameNumbers);
        Integer min = copyGameNumbers.get(0);
        Integer max = copyGameNumbers.get(gameNumbers.size() -1);
        return minValue <= min && maxValue >= max;
    }
}
