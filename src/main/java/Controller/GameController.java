package Controller;

import domain.BaseBalls;
import domain.Score;

import java.util.Scanner;


public class GameController {
    static final String INPUT_THREE_NUMBER = "추측하고자 하는 서로 다른 세자리 수를 입력하세요.";
    static final Scanner scanner = new Scanner(System.in);
    static final String CORRECT_ALL_SCORE = "3 스트라이크";
    static final int START_RANGE = 100;
    static final int END_RANGE = 999;

    private static void oneRound(BaseBalls computer) {
        System.out.println(INPUT_THREE_NUMBER);
        BaseBalls user = new BaseBalls(scanner.next());
        String score = Score.finalScore(user.ballNumber(computer), user.strikeNumber(computer));
        System.out.println(score);
        if(score.equals(CORRECT_ALL_SCORE)) {
            return;
        }
        oneRound(computer);
    }

    public static void start() {
        String answer = util.RandomNumberGenerator.nextString(START_RANGE, END_RANGE);
        System.out.println(answer);
        BaseBalls computer = new BaseBalls(answer);
        oneRound(computer);

    }


}
