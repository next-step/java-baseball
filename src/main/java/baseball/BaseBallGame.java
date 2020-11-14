package baseball;

public class BaseBallGame {

    private final InputScanner inputScanner;
    public BaseBallGame(){
        inputScanner = new ConsoleInputScanner();
    }

    private void play(String answer){
        BallCount ballCount;
        do {
            String input = inputScanner.inputNumberLength3();
            ballCount = BallCountChecker.check(input, answer);
            BallCountPrinter printer = new BallCountPrinter(ballCount);
            printer.print();
        } while (!ballCount.isEndGame());
        System.out.println(GameResource.TEXT_GAME_END);
        restart();
    }

    public void start(){
        play("713");
    }

    public void restart(){
        String inputRestart;

        inputRestart = inputScanner.inputNumber1Or2();
        if(isRestartGame(inputRestart)){
            play("123");
        }
    }

    public boolean isRestartGame(String input){
        return "1".equals(input) ? true : false;
    }
}
