package features;

import io.PrintOutput;

public class PrintResult {
    public static void checkResult(int strike, int ball, PrintOutput printOutput) {
        if (strike == 0 && ball == 0) {
            printOutput.printNothing();
        } else if (strike == 0) {
            printOutput.printBall(ball);
        } else if (ball == 0) {
            printOutput.printStrike(strike);
        } else {
            printOutput.printStrikeAndBall(strike, ball);
        }
    }
}
