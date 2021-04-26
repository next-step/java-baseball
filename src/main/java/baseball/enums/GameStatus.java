package baseball.enums;

public enum GameStatus {
    PLAY("1") {
        @Override
        public void printMessage() {
            System.out.print("숫자를 입력해 주세요 : ");
        }
    },
    END("0") {
        @Override
        public void printMessage() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
        }
    },
    EXIT("2");

    private final String code;
    GameStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void printMessage() { }
}
