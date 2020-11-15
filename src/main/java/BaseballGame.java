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
        // 컴퓨터, 플레이어 생성
        Computer computer = new Computer();
        System.out.println(START_GAME_MSG);
        while(isGamePlaying) {
            Player player = new Player();
            computer.generateNumberSet();
            startPlayerInput(computer, player);
            System.out.println(FINISH_GAME_MSG);
            System.out.println(REPLAY_MSG);
            isGamePlaying = player.requestInput(false) == 1;
        }
    }

    public void startPlayerInput(Computer computer, Player player) {
        while (player.getStrikeCount() < 3) {
            player.initBallCount();
            String resultText = getDiffResultText(computer, player, player.requestInput(true));
            System.out.println(resultText);
        }
    }

    public String getDiffResultText(Computer c, Player p, int number) {
        if (number == BaseballGame.INPUT_ERROR) return INVALID_INPUT_MSG;
        p.convertNumberToList(number);
        String ballCountTxt = "";
        return ballCountTxt.trim();
    }

    public CountType calcBallCount(Computer c, Player p, int playerNumberIndex) {
    }

    enum CountType {
        STRIKE("스트라이크"),
        BALL("볼"),
        FOUR_BALL("포볼"),
        NOTHING("낫싱");
        CountType(String txt) {}
    }
}