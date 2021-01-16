public class GameManager {

    private final Input input;
    private boolean continuesGame;

    public GameManager(Input input) {
        this.input = input;
        this.continuesGame = true;
    }

    // TODO: 테스트 추가
    /**
     * GameManager가 새로운 게임을 시작합니다.
     *
     * @return 게임이 끝난 후, 플레이어가 새로운 게임을 시작하고자 하는지 여부
     */
    public boolean start() {
        Numbers answerNumbers = RandomNumbersGenerator.generate();
        continuesGame = true;
        do {
            Numbers playerNumbers = getPlayerNumbersByInput();
            BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
            ballCount.printCountMessages();
            if (ballCount.isThreeStrikes()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                continuesGame = false;
            }
        } while (continuesGame);
        return askPlayerToPlayNewGame();
    }

    private Numbers getPlayerNumbersByInput() {
        Numbers numbers = null;
        String playerNumber = input.getInputValue("숫자를 입력해 주세요 : ");
        boolean incorrectInput = true;
        while (incorrectInput) {
            try {
                numbers = new Numbers(playerNumber);
                incorrectInput = false;
            } catch (IllegalArgumentException exception) {
                System.out.print(exception.getMessage());
                playerNumber = input.getInputValue();
            }
        }
        return numbers;
    }

    private boolean askPlayerToPlayNewGame() {
        String playerResponse = input.getInputValue("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        return playerResponse.equals("1");
    }
}
