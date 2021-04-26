import exception.NotNumberException;
import questionnumber.Computer;
import questionnumber.QuestionNumber;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new Computer(new QuestionNumber()));
        baseballGame.setQuestionNumber();

        Scanner scan = new Scanner(System.in);
        StringBuilder inputString = new StringBuilder();
        while (true) {
            stringBuilderClear(inputString);
            System.out.print("숫자를 입력해주세요 : ");

            try {
                inputString.append(scan.next());
                isNumberValidation(inputString.toString());
            } catch(NotNumberException e) {
                System.out.println(e.getMessage());
                continue;
            }

            baseballGame.checkPresentationNumber(inputString.toString());
            baseballGame.getReferee().printScore();

            if (baseballGame.getReferee().getStrike() < 3) {
                baseballGame.getReferee().initializeCount();
                continue;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if (scan.next().equals("1")) {
                baseballGame.getReferee().initializeCount();
                baseballGame.setQuestionNumber();
                continue;
            }

            break;
        }
    }

    /**
     * validation input string
     * @param value
     */
    public static void isNumberValidation(String value) {
        if (!value.matches("^[0-9]+$")) {
            throw new NotNumberException();
        }
    }

    /**
     * string builder clear
     * @param stringBuilder
     * @return
     */
    public static StringBuilder stringBuilderClear(StringBuilder stringBuilder) {
        return stringBuilder.delete(0, stringBuilder.length());
    }
}
