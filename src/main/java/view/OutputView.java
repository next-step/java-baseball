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
        int countOfBall = result.getBallCount();
        int countOfStrike = result.getStrikeCount();
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
