package baseball;

import java.util.List;

import helper.ScannerHelper;
import util.NumberUtil;

public class Baseball {
    private static Baseball baseball = new Baseball();
    private final ScannerHelper scannerHelper;
    private List<Integer> answerList;
    private Result result;

    private Baseball() {
        this.scannerHelper = ScannerHelper.getInstance();
        this.answerList = NumberUtil.generate();
        this.result = Result.getInstance();
    }

    public static Baseball getInstance() {
        return baseball;
    }

    public void run() {
        do {
            List<Integer> guessList = scannerHelper.getGuess();
            judge(guessList, answerList);
        } while (true);
    }

    protected void judge(final List<Integer> guessList, final List<Integer> answerList) {
        if (answerList.equals(guessList)) {
            replayOrEnd();
            return;
        }

        for (int i = 0; i < answerList.size(); i++) {
            this.checkStrikeOrBall(guessList, answerList.get(i), i);
        }

        System.out.println(result.toString());
    }

    protected void checkStrikeOrBall(final List<Integer> guessList, final Integer number, final int index) {
        final int guessIndex = guessList.indexOf(number);

        if (guessIndex == index) {
            result.addStrike();
        } else if (guessIndex != -1) {
            result.addBall();
        }
    }

    protected void replayOrEnd() {
        if (scannerHelper.getOption() == 2) {
            System.exit(0);
        }

        this.answerList = NumberUtil.generate();
    }
}
