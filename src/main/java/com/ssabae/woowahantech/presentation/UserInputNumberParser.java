package com.ssabae.woowahantech.presentation;

import com.ssabae.woowahantech.domain.baseballnumber.BaseballNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class UserInputNumberParser {

    public BaseballNumbers parse(String str) {
        List<Integer> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            addNumericValue(list, c);
        }
        return new BaseballNumbers(list);
    }

    private void addNumericValue(List<Integer> list, char c) {
        if (Character.isDigit(c)) {
            list.add(Character.getNumericValue(c));
        }
    }
}
