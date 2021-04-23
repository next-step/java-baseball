package baseball;

public class BaseBallGame {
    private final BaseBallRandomNumber randomNumber = new BaseBallRandomNumber();

    public void newGame() {
        randomNumber.initialize();
    }

    public void startGame() {
        String guess = "";
        while (!randomNumber.isCorrect(guess)) {
            guess = UserInterface.printGuideAndScanUserInput();
            noticeStrikeCount(guess);
        }
        UserInterface.printGameComplete();
    }
    
    private void noticeStrikeCount(String guess) {
        int strike = randomNumber.getStrikeCount(guess);
        if (strike > 0) {
            UserInterface.printStrike(strike);
        }
    }
}
