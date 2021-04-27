package domain;

public enum State {

    STRIKE("스트라이크"),
    BOLL("볼"),
    NOTHING("아웃");

    private String kor;

    State(String kor) {
        this.kor = kor;
    }

    public String getKor() {
        return kor;
    }
}
