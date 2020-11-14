package view;

import domain.GuessResult;

public class OutputView {
    private OutputView() {

    }

    public static void printResult(GuessResult guessResult) {
        if (guessResult.isNothing()) {
            System.out.println("낫띵");
            return;
        }
        printHint(guessResult);
    }

    private static void printHint(GuessResult guessResult) {
        int strikeCount = guessResult.getStrikeCount();
        int ballCount = guessResult.getBallCount();
        String strikePrint = getPrint(strikeCount, "%s 스트라이크 ");
        String ballPrint = getPrint(ballCount, "%s 볼");
        System.out.println(String.format("%s%s", strikePrint, ballPrint));
    }

    public static String getPrint(int count, String printFormat) {
        String strikePrint = "";
        if (count != 0) {
            strikePrint = String.format(printFormat, count);
        }
        return strikePrint;
    }
}
