public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String korean;

    Hint(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return this.korean;
    }
}
