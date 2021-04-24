package com.woowahan.precourse.baseball.domain;

public class BaseBallGame {

    private String generateRandomNumber() {
        return String.valueOf((int) (Math.random() * 9 + 1));
    }
}
