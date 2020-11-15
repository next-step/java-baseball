package com.ssabae.woowahantech.validator;

import java.util.List;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class ListSizeValidator implements Validator<List<Integer>> {

    private final int validSize;

    protected ListSizeValidator(int validSize) {
        this.validSize = validSize;
    }

    @Override
    public boolean validate(List<Integer> gameNumbers) {
        if (gameNumbers == null || gameNumbers.isEmpty()) {
            return false;
        }
        return gameNumbers.size() == validSize;
    }
}
