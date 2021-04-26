public enum Message {
    LESS_THAN_1("1 이상 입력해 주세요.");

    private String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
