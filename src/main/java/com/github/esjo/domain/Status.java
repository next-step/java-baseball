package com.github.esjo.domain;

// Player의 상태를 정의
public enum Status {
    INIT("0"), // (재)시작 직후 상태
    PLAY("1"), // 게임중
    QUIT("2"), // 게임중단
    PASS("3"), // 상대방숫자 맞춤
    FAIL("4"); // 상대방숫자 틀림

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
