package baseball.etc;

public enum Message {
    LESS_THAN_1("1 이상 입력해 주세요."),
    NUMBER_REQUIRED("숫자는 필수값 입니다."),
    ONLY_LIMIT_CHARACTERS("{}자로만 입력해주세요.");

    private String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getTextWithWord(String...word) {
        String textTemp = this.getText();

        for (int i = 0; i < word.length; i++) {
            textTemp = textTemp.replaceFirst("\\{\\}", word[i]);
        }

        return textTemp;
    }
}
