package com.ssabae.woowahantech.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-11
 */
public class BaseballNumberValidator implements Validator<List<Integer>> {

    private final List<Validator<List<Integer>>> validators;

    public BaseballNumberValidator() {
        validators = new ArrayList<>();
        addValidator(new ContainsOnlyOnceValidator());
        addValidator(new ListSizeValidator(3));
        addValidator(new NumberRangeValidator(1, 9));
    }

    private void addValidator(Validator<List<Integer>> validator) {
        validators.add(validator);
    }

    @Override
    public boolean validate(List<Integer> baseballNumbers) {
        for (Validator<List<Integer>> validator : validators) {
            // FIXME: 리팩토링시에 Depth 줄이기
            if (!validator.validate(baseballNumbers)) {
                return false;
            }
        }
        return true;
    }
}
