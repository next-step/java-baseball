package baseball.view;

public enum SelectOption {
    RESTART("1", true),
    STOP("2", false);

    private final String number;
    private final boolean restart;

    private SelectOption(String number, boolean restart) {
        this.number = number;
        this.restart = restart;
    }

    public static SelectOption of(String number) {
        for (SelectOption options : values()) {
            if (options.checkInput(number)) {
                return options;
            }
        }
        throw new IllegalArgumentException("입력하신 " + number + "는 유효하지 않은 값입니다.");
    }

    private boolean checkInput(String number) {
        return this.number.equals(number);
    }

    public boolean isRestart() {
        return restart;
    }
}
