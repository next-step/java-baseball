package homework.baseball;

import homework.baseball.util.ValidationChecker;
import homework.baseball.value.Answer;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    private final String RETRY = "1";

    String getRandomNumber() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() != 3) {
            numberSet.add(new Random().nextInt(9) + 1);
        }
        StringBuffer strBuffer = new StringBuffer();
        for (Integer number : numberSet) {
            strBuffer.append(number);
        }
        return strBuffer.toString();
    }

    Answer getInitAnswer() {
        return new Answer(getRandomNumber());
    }

    boolean isRetryOrNot(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String retryStr = null;
        do {
            retryStr = scanner.next();
        } while (!ValidationChecker.isCorrectFormatForRetry(retryStr));
        return RETRY.equals(retryStr);
    }

    Answer getUserAnswer(Scanner scanner) {
        System.out.print("숫자를 입력해주세요: ");
        String answerStr = null;
        do {
            answerStr = scanner.next();
        } while (!ValidationChecker.isCorrectFormatForAnswer(answerStr));
        return new Answer(answerStr);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        do {
            Answer answer = getInitAnswer();
            while (!answer.compareWithUserAnswer(getUserAnswer(scanner))) ;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        } while (isRetryOrNot(scanner));
        scanner.close();
    }
}
