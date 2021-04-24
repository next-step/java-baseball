package me.nimkoes.baseball.view;

public enum Message {
    USER_INPUT("숫자를 입력해주세요 : "),
    STRIKE(" 스트라이크 "),
    BALL(" 볼"),
    NOTHING("낫싱"),
    ENDING("개의 숫자를 모두 맞히셨습니다! 게임종료"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
