package baseball;

public class BaseBallGame {

    private final InputScanner inputScanner;
    public BaseBallGame(){
        inputScanner = new ConsoleInputScanner();
    }

    public void play(String answer){
        BallCount ballCount;
        do {
            String input = inputScanner.inputNumberLength3();
            ballCount = BallCountChecker.check(input, answer);
            System.out.println(ballCount.toString());
        } while (!ballCount.isEndGame());

    }
}
