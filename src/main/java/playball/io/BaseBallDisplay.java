package playball.io;

import playball.domain.Balls;
import playball.domain.Hint;
import playball.domain.HintResult;
import playball.domain.HintResults;

import java.util.List;
import java.util.Scanner;

public class BaseBallDisplay {

    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static Scanner scanner = new Scanner(System.in);

    public static int input() {
        System.out.print(INPUT_MESSAGE);
        return scanner.nextInt();
    }

    public static void output(HintResults hintResults) {
        List<HintResult> results = hintResults.getHintResults();
        for (HintResult result : results) {
            printHintMessage(result);
        }
        System.out.println();
    }

    private static void printHintMessage(HintResult result) {

        if (result.getHint().equals(Hint.NOTHING) && result.getCount().equals(Balls.BALLS_SIZE)) {
            System.out.print(result.getHint().getDescription());
            return;
        }

        System.out.print(result.getCount() + " " + result.getHint().getDescription() + " ");
    }
}
