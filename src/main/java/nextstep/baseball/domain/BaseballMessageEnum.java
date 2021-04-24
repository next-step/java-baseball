package nextstep.baseball.domain;

public enum BaseballMessageEnum {
    Q1("숫자를 입력해주세요 : "),
    Q2("게임을새로시작하려면1,종료하려면2를입력하세요."),
    E1("3개의숫자를모두맞히셨습니다! 게임종료");

    String message;

    BaseballMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
