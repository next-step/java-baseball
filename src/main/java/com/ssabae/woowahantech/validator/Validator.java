package com.ssabae.woowahantech.validator;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-11
 */
public interface Validator<T> {
    boolean validate(T str);
}
