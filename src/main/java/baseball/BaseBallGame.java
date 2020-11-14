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
            BallCountPrinter printer = new BallCountPrinter(ballCount);
            printer.print();
        } while (!ballCount.isEndGame());

    }
}
