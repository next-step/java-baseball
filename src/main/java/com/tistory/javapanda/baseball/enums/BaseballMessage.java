package com.tistory.javapanda.baseball.enums;

public enum BaseballMessage {

    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    FINISH_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    BaseballMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
