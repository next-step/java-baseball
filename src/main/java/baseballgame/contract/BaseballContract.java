package baseballgame.contract;

public class BaseballContract {
    // system
    public static final String PROG_START = "프로그램 시작. 환영합니다.";
    public static final String PROG_STOP = "프로그램 종료. 안녕히 가세요.";

    // game contract values
    public static final String NEW_GAME_CHAR = "1";
    public static final String STOP_GAME_CHAR = "2";

    // game strings
    public static final String GAME_START = "게임 시작!";
    public static final String GAME_END = "모두 맞히셨습니다! 게임 종료!";
    public static final String GAME_RETRY_NOTI =
            "게임을 새로 시작하시려면 " + NEW_GAME_CHAR + ",  종료하시려면 " + STOP_GAME_CHAR + "를 입력하세요";

    public static final String WAIT_INPUT = "숫자 3자리를 입력해주세요";

    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
}
