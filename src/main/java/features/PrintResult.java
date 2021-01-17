package features;

import io.PrintOutput;

public class PrintResult {
    /**
     * Checking result and print out correct result.
     * @param strike Integer of strike count
     * @param ball Integer of ball count
     * @param printOutput Print Output module from io package.
     */
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
