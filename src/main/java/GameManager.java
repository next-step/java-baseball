public class GameManager {

    private final Input input;

    public GameManager(Input input) {
        this.input = input;
    }

    public void start() {
        Numbers answerNumbers = RandomNumbersGenerator.generate();
        Numbers playerNumbers = getPlayerNumbersByInput();
        BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
        System.out.println(ballCount.getBallCountMessage());
    }

    private Numbers getPlayerNumbersByInput() {
        String inputValue = this.input.getInputValue("숫자를 입력해 주세요 : ");
        return new Numbers(inputValue);
    }
}
