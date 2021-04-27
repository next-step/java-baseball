package playball.io;

import playball.domain.Ball;
import playball.domain.Balls;
import playball.domain.Hint;
import playball.domain.HintResult;
import playball.domain.HintResults;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallDisplay {

    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String OUTPUT_OF_FINISH_MESSAGE = Balls.BALLS_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임종료";
    public static final String OUTPUT_OF_RE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static Scanner scanner = new Scanner(System.in);

    public static Balls input() {
        System.out.print(INPUT_MESSAGE);

        String[] inputs = scanner.nextLine().split("");
        List<Ball> inputBalls = new ArrayList<>();
        for (String input : inputs) {
            Ball ball = Ball.of(Integer.valueOf(input));
            inputBalls.add(ball);
        }

        return Balls.of(inputBalls);
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

        if (!result.getHint().equals(Hint.NOTHING) && !result.getCount().equals(0)) {
            System.out.print(result.getCount() + " " + result.getHint().getDescription() + " ");
        }
    }

    public static GamePlayStatus outputOfFinishMessage() {
        System.out.println(OUTPUT_OF_FINISH_MESSAGE);
        System.out.println(OUTPUT_OF_RE_MESSAGE);
        int input = scanner.nextInt();
        return GamePlayStatus.findGamePlayStatus(input);
    }
}
