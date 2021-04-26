package com.study.application.enums;

/**
 * @author Jaedoo Lee
 */
public enum InputGameContinue {

    NEW_GAME(1),
    EXIT_GAME(2);

    final int value;

    InputGameContinue(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
