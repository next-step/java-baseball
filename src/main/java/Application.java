import component.*;
import model.PatternResult;
import model.ThreeDigits;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        do {
            ThreeDigits answer = AnswerCreator.createAnswer();
            doPlay(answer);
        } while(doRetryQuery());
    }

    private static void doPlay(ThreeDigits answer) {
        boolean isOver = false;

        while (!isOver) {
            System.out.print("3개의 숫자를 입력해주세요: ");

            ThreeDigits actual = inputThreeDigits();
            PatternResult patternResult = new PatternAnalyzer(actual, answer).analyze();

            System.out.println(PatternDisplayFormatter.format(patternResult));

            isOver = AnswerChecker.isPatternForAnswer(patternResult);
        }

        System.err.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean doRetryQuery() {
        System.err.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = inputByPattern("[12]");
        return input.equals("1");
    }

    private static ThreeDigits inputThreeDigits() {
        return ThreeDigitsFactory.createFrom(inputByPattern("[1-9]{3}"));
    }

    private static String inputByPattern(String pattern) {
        while (true) {
            try {
                return new Scanner(System.in)
                        .next(pattern);
            } catch (NoSuchElementException e) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }
}
