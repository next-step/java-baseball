public class BaseballGame {
    final static int CHECK_NUMBER_SIZE = 3;

    String START_GAME_MSG = "게임을 시작합니다.";
    String FINISH_GAME_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    String REPLAY_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String INVALID_INPUT_MSG = "숫자를 잘못 입력하셨습니다. 다시 입력해 주세요.";

    public static final int INPUT_ERROR = -1;

    boolean isGamePlaying = true;

    public BaseballGame() {
    }

    public void playGame() {
    }

    public void startPlayerInput(Computer computer, Player player) {
    }

    enum CountType {
        STRIKE("스트라이크"),
        BALL("볼"),
        FOUR_BALL("포볼"),
        NOTHING("낫싱");
        CountType(String txt) {}
    }
}