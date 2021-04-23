package domain.enums;

public enum GameStatus {
    RESTART("1", true),
    STOP("2", false);

    private final String number;
    private final boolean restart;

    GameStatus(String number, boolean restart) {
        this.number = number;
        this.restart = restart;
    }

    public static GameStatus of(String number) {
        for (GameStatus options : GameStatus.values()) {
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
