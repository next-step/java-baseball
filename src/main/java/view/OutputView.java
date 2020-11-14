package view;

import domain.Result;
import domain.SpecialResultType;

public class OutputView {
    private OutputView() {

    }

    public static void printResult(Result result) {
        if (result.equals(SpecialResultType.NOTHING)) {
            System.out.println("낫띵");
            return;
        }
        printHint(result);
    }

    private static void printHint(Result result) {
        int countOfStrike = result.getStrikeCount();
        int countOfBall = result.getBallCount();
        String strikePrint = getPrint(countOfStrike, "%s 스트라이크 ");
        String ballPrint = getPrint(countOfBall, "%s 볼");
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
