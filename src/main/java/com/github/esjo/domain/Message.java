package com.github.esjo.domain;

// 실행결과에 출력되는 메세지관련 문자열 정의.
public enum Message {

    THREE_STRIKE_MSG("3개의숫자를모두맞히셨습니다! 게임종료\n"),
    NOTHING_MSG("낫싱"),
    RESTART_MSG("게임을새로시작하려면1,종료하려면2를입력하세요.\n");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
