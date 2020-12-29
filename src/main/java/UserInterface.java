import exception.DuplicateNumberException;
import exception.NumberLengthException;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {

    private boolean isGameFinished = false;
    private final String QUIZ_MESSAGE = "숫자를 입력주세요 : ";
    private final int ANSWER_LENGTH = 3;

    private QuizGenerator quizGenerator = new QuizGenerator(ANSWER_LENGTH);

    public void run() {
        while(!isGameFinished) {
            isGameFinished = playGame();
        }

        System.exit(0);
    }

    private boolean playGame() {
        int inputNumber = 0;
        Scanner sc = new Scanner(System.in);
        int answerNumber = quizGenerator.generate();

        System.out.println("테스트용 정답 출력 : " + answerNumber);

        inProgressGame(sc, inputNumber, answerNumber);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        inputNumber = sc.nextInt();

        return inputNumber != 1;
    }

    private void inProgressGame(Scanner sc, int inputNumber, int answerNumber) {
        CountChecker countChecker = new CountChecker(answerNumber);

        while(inputNumber != answerNumber) {
            try {
                printQuizMessage();
                inputNumber = sc.nextInt();
                checkInputNumberFormat(inputNumber);
            } catch (NumberLengthException error) {
                System.out.println("잘못된 입력입니다. 입력 숫자의 길이를 맞춰주세요. 길이 : " + ANSWER_LENGTH);
                continue;
            } catch (DuplicateNumberException error) {
                System.out.println("잘못된 입력입니다. 중복된 수를 제거해주세요.");
                continue;
            } catch (Exception error) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                sc.next();
                continue;
            }
            countChecker.check(inputNumber);
        }
    }

    private void checkInputNumberFormat(int inputNumber) {
        String input = String.valueOf(inputNumber);

        if(input.length() != ANSWER_LENGTH) throw new NumberLengthException();
        if(duplicateCheckInputNumber(input)) throw new DuplicateNumberException();
        if(!isNumber(input)) throw new NumberFormatException();
    }

    private boolean duplicateCheckInputNumber(String inputNumber) {
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < inputNumber.length(); i++) {
            set.add(inputNumber.charAt(i));
        }

        return set.size() != ANSWER_LENGTH;
    }

    private boolean isNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    private void printQuizMessage() {
        System.out.print(QUIZ_MESSAGE);
    }
}
