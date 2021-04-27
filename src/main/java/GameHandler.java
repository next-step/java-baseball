
public class GameHandler {

    GameIO io;
    Referee referee;

    public GameHandler() {
        io = new GameIO();
        referee = new Referee();
    }
    
    public boolean playGame() {
        referee.initNumber();
        doGame();
        return doGameAgain();
    }

    public boolean playGame(String number) {
        referee.setNumber(number);
        doGame();
        return doGameAgain();
    }
    
    public void doGame() {
        int strike = 0;
        while (strike != 3) {
            io.printInputNumber();
            strike = checkStrikeBall(io.inputFromUser());
        }
    }

    private int checkStrikeBall(String inputNumber) {
        int strike = referee.checkStrike(inputNumber);
        int ball = referee.checkBall(inputNumber);
        io.printStrikeBall(strike, ball);
        return strike;
    }

    private boolean doGameAgain() {
        io.printEndGame();
        String inputNumber = io.inputFromUser();
        if (inputNumber.equals("1"))
            return true;
        if (inputNumber.equals("2"))
            return false;
        return false;
    }


}
