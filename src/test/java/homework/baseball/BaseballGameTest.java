package homework.baseball;

import homework.baseball.value.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    private String answer;
    private String retry;
    private StringBuffer userAnswers;
    private StringBuffer userRtries;

    @BeforeEach
    public void beforeEach() {
        answer = "12A3\n4566\n56A\n!61\n335\n437";
        retry = "3\n12\n1a\nA\n2";
        userAnswers = new StringBuffer();
        userRtries = new StringBuffer("1\n1\n1\n2");
        for (int first = 1; first < 10; first++) {
            for (int second = 1; second < 10; second++) {
                if (first == second) {
                    continue;
                }
                for (int third = 1; third < 10; third++) {
                    if (first == third || second == third) {
                        continue;
                    }
                    userAnswers.append(new StringBuffer().append(first).append(second).append(third).append("\n"));
                }
            }
        }
    }

    @Test
    public void getUserAnswerTest() {
        BaseballGame baseballGame = new BaseballGame();
        Scanner scanner = new Scanner(answer);
        Answer asnwer = baseballGame.getUserAnswer(scanner);
        assertThat(asnwer.compareWithUserAnswer(new Answer("437"))).isTrue();
        scanner.close();
    }

    @Test
    public void isRetryOrNotTest() {
        BaseballGame baseballGame = new BaseballGame();
        Scanner scanner = new Scanner(retry);
        boolean isRetry = baseballGame.isRetryOrNot(scanner);
        assertThat(isRetry).isFalse();
        scanner.close();
    }

    @Test
    public void runTest() {
        for (int t = 0; t < 10; t++) {
            Scanner userRtriesScanner = new Scanner(userRtries.toString());
            BaseballGame baseballGame = new BaseballGame();
            do {
                Scanner userAnswerScanner = new Scanner(userAnswers.toString());
                Answer answer = baseballGame.getInitAnswer();
                while (!answer.compareWithUserAnswer(baseballGame.getUserAnswer(userAnswerScanner))) ;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                userAnswerScanner.close();
            } while (baseballGame.isRetryOrNot(userRtriesScanner));
            userRtriesScanner.close();
        }
    }
}