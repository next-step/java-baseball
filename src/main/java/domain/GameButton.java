package domain;

public enum GameButton {
    GO(1), STOP(2);

    private final int value;

    GameButton(final int value) {
        this.value = value;
    }

    public GameButton findBy(final int value) {
        for (GameButton gameButton : values()) {
            if (gameButton.getValue() == value) {
                return gameButton;
            }
        }
        throw new IllegalArgumentException("일치하는 값이 없습니다.");
    }

    public int getValue() {
        return value;
    }

    public boolean isStop() {
        return value == 2;
    }
}
