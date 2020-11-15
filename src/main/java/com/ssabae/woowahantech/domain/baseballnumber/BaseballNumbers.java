package com.ssabae.woowahantech.domain.baseballnumber;

import java.util.Collections;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class BaseballNumbers {

    private final List<Integer> baseballNumberList;

    public BaseballNumbers(List<Integer> baseballNumberList) {
        this.baseballNumberList = baseballNumberList;
    }

    public List<Integer> getBaseballNumberList() {
        return Collections.unmodifiableList(baseballNumberList);
    }
}
