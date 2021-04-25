package baseball;

import java.util.Scanner;

public class BaseballMainApp {

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        Scanner scanner = new Scanner(System.in);

        boolean isFinished = false;
        while (!isFinished) {
            String baseballNumber = baseball.makeBaseballNumberString();

            boolean foundCorrectAnswer = false;
            while (!foundCorrectAnswer) {
                System.out.print("숫자를 입력해주세요 : ");
                int inputNumber = scanner.nextInt();

                if (baseball.isValidBaseballInputNumber(inputNumber)) {
                    int strikes = baseball.countStrikes(baseballNumber, Integer.toString(inputNumber));
                    int balls = baseball.countBalls(baseballNumber, Integer.toString(inputNumber));

                    String resultSentence = baseball.makeComparisonResultString(new BaseballComparisonResult(strikes, balls));

                    System.out.println(resultSentence);

                    if (strikes == 3) {
                        foundCorrectAnswer = true;

                        int newGame = scanner.nextInt();

                        if (newGame == 2) {
                            isFinished = true;
                        }
                    }
                }

            }
        }

    }

}
