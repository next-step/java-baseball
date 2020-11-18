package com.github.sangholeedev.javabaseball;

public enum BallDecision {
    BALL("볼"), STRIKE("스트라이크"), NOT_THING("낫싱");

    private final String printName;

    BallDecision(String printName) {
        this.printName = printName;
    }

    public String getPrintName() {
        return printName;
    }
}
