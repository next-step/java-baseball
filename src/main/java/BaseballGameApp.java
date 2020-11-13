import domain.AnswerNumber;
import domain.Referee;
import domain.UserNumber;

import java.util.Scanner;

public class BaseballGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AnswerNumber answerNumber = AnswerNumber.init();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int userNumberRaw = Integer.parseInt(scanner.nextLine());

            UserNumber userNumber = new UserNumber(userNumberRaw);
            Referee referee = new Referee(answerNumber);
            int countOfStrike = referee.getCountOfStrike(userNumber);
            int countOfBall = referee.getCountOfBall(userNumber);

            printResult(countOfStrike, countOfBall);

            if (countOfStrike != 3) {
                continue;
            }

            System.out.println("게임을 새로 시작할려면 1, 종료하려면 2를 입력하세요.");
            int continueInput = Integer.parseInt(scanner.nextLine());
            if (continueInput == 2) {
                break;
            }
            if (continueInput == 1) {
                answerNumber = AnswerNumber.init();
                continue;
            }
            throw new IllegalArgumentException("1 또는 2의 값을 입력해야합니다.");
        }
    }

    private static void printResult(int countOfStrike, int countOfBall) {
        if (countOfBall == 0 && countOfStrike == 0) {
            System.out.println("낫띵");
            return;
        }
        String strikePrint = getPrint(countOfStrike, "%s 스트라이크 ");
        String ballPrint = getPrint(countOfBall, "%s 볼");
        System.out.println(String.format("%s%s", strikePrint, ballPrint));
    }

    private static String getPrint(int count, String printFormat) {
        String strikePrint = "";
        if (count != 0) {
            strikePrint = String.format(printFormat, count);
        }
        return strikePrint;
    }
}
