package me.nimkoes.baseball.view;

public enum Message {
    USER_INPUT("숫자를 입력해주세요 : "),
    STRIKE(" 스트라이크 "),
    BALL(" 볼"),
    NOTHING("낫싱"),
    ENDING("개의 숫자를 모두 맞히셨습니다! 게임종료"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INVALID_FORMAT("숫자만 입력할 수 있습니다."),
    INVALID_LENGTH("자리 숫자를 입력해주세요."),
    INVALID_DUPLICATE_NUMBER("서로 다른 숫자만 입력할 수 있습니다."),
    INVALID_ENDING_VALUE("1 또는 2 를 입력해주세요.");

    String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
