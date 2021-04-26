package baseball.view;

public enum Continuable {
    CONTINUE("1"),
    BREAK("2"),
    UNKNOWN;

    private String keyword;

    Continuable(){}

    Continuable(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
