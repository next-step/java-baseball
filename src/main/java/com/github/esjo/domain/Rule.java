package com.github.esjo.domain;

// 해당 상수값들은 변경되면, 로직 모두 변경되어야해서 Rule로 정의
public enum Rule {
    MIN(1),
    MAX(9),
    NUMBER_OF_DIGITS(3); // 야구게임은 3자리 수로 진행. 플레이어로 부터 3자리의 정수를 입력 받음.

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
