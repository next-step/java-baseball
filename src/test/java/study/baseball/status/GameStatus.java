package study.baseball.status;

public enum GameStatus {
    PLAY() {
        @Override
        public void printMessage() {
            System.out.print("숫자를 입력해 주세요 : ");
        }
    },
    END() {
        @Override
        public void printMessage() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
        }
    };

    public void printMessage() { }
}
