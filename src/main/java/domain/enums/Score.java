package domain.enums;

public enum Score {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String title;

    Score(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
