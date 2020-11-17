public class Game {

    private RandomNumber randomNumber;
    private NumberCheckResult numberCheckResult;
    private NumberChecker numberChecker;
    private boolean ended;

    public static Game initialize(int numberLength) {
        Game game = new Game();
        game.randomNumber = RandomNumber.generate(numberLength);
        game.numberChecker = new NumberChecker(numberLength, game.randomNumber);
        game.ended = false;
        return game;
    }

    private Game() {
    }

    public void checkNumber(String numbers) {
        this.numberCheckResult = numberChecker.check(numbers);
        this.ended = numberCheckResult.correct();
    }

    public String getResult() {
        return numberCheckResult.toString();
    }

    public boolean isEnded() {
        return ended;
    }

}
