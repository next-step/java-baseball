public class GameManager {

    private final Input input;
    private boolean continuesGame;

    public GameManager(Input input) {
        this.input = input;
        this.continuesGame = true;
    }

    public void start() {
        Numbers answerNumbers = RandomNumbersGenerator.generate();
        do {
            Numbers playerNumbers = getPlayerNumbersByInput();
            BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
            System.out.println(ballCount.getBallCountMessage());
            if (ballCount.isThreeStrikes()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                continuesGame = false;
            }
        } while (continuesGame);
    }

    private Numbers getPlayerNumbersByInput() {
        Numbers numbers = null;
        String inputValue = this.input.getInputValue("숫자를 입력해 주세요 : ");
        boolean incorrectInput = true;
        while (incorrectInput) {
            try {
                numbers = new Numbers(inputValue);
                incorrectInput = false;
            } catch (IllegalArgumentException exception) {
                System.out.print(exception.getMessage());
                inputValue = this.input.getInputValue();
            }
        }
        return numbers;
    }
}
