public class GameManager {

    private static final String PLAYER_REACTION_YES = "1";

    private final Input input;
    private boolean continuesGame;

    public GameManager(Input input) {
        this.input = input;
        this.continuesGame = true;
    }

    /**
     * GameManager가 새로운 게임을 시작합니다.
     *
     * @return 게임이 끝난 후, 플레이어가 새로운 게임을 시작하고자 하는지 여부
     */
    public boolean start() {
        Numbers answerNumbers = RandomNumbersGenerator.generate();
        continuesGame = true;
        do {
            playOneGame(answerNumbers);
        } while (continuesGame);
        return askPlayerToPlayNewGame();
    }

    private void playOneGame(Numbers answerNumbers) {
        Numbers playerNumbers = getPlayerNumbersByInput();
        BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
        ballCount.printDetailedCountMessage();
        if (ballCount.isThreeStrikes()) {
            System.out.println(OutputMessage.GAME_FINISHED);
            continuesGame = false;
        }
    }

    private Numbers getPlayerNumbersByInput() {
        Numbers numbers = null;
        String playerNumber = input.getInputValue(OutputMessage.PLEASE_ENTER_NUMBER.toString());
        boolean incorrectInput = true;
        while (incorrectInput) {
            try {
                numbers = new Numbers(playerNumber);
                incorrectInput = false;
            } catch (IllegalArgumentException exception) {
                System.out.print(exception.getMessage() + OutputMessage.PLEASE_ENTER_AGAIN);
                playerNumber = input.getInputValue();
            }
        }
        return numbers;
    }

    private boolean askPlayerToPlayNewGame() {
        String playerResponse = input.getInputValue(OutputMessage.PLAY_A_NEW_GAME_OR_NOT.toString());
        return playerResponse.equals(PLAYER_REACTION_YES);
    }
}
