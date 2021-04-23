package nextstep.baseball.domain;

public enum BaseballEnum {
    STRIKE("strike","스트라이크"),
    BALL("ball","볼"),
    NOTHING("nothing","낫싱");

    String code;
    String name;

    BaseballEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName(){
        return this.name;
    }
}
