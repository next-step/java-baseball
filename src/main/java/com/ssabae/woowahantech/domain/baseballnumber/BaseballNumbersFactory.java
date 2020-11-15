package com.ssabae.woowahantech.domain.baseballnumber;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class BaseballNumbersFactory {

    private static final BaseballNumbersGenerator generator = new BaseballNumbersGenerator();

    public static BaseballNumbers generator() {
        return generator.generate();
    }
}
