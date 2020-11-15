package com.ssabae.woowahantech.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class ContainsOnlyOnceValidator implements Validator<List<Integer>> {

    protected ContainsOnlyOnceValidator() {

    }

    @Override
    public boolean validate(List<Integer> gameNumbers) {
        if (gameNumbers == null || gameNumbers.isEmpty()) {
            return false;
        }
        Set<Integer> set = new HashSet<>(gameNumbers);
        return set.size() == gameNumbers.size();
    }
}
