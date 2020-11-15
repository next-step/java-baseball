package baseball.game.view;

import baseball.game.domain.game.BaseBallGame;
import baseball.game.domain.game.BaseBallGameResultType;
import baseball.game.domain.generator.DirectBallsGenerator;
import baseball.game.domain.generator.RandomBallsGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args) {
        boolean gameFlag;

        do {
            BaseBallGame baseBallGame = BaseBallGame.createGame(RandomBallsGenerator.generate());
            BaseBallGameResultType result;

            Scanner scanner = new Scanner(System.in);
            do {
                List<Integer> numbers = getIntegers(scanner);
                result = baseBallGame.getResult(DirectBallsGenerator.generate(numbers));
                System.out.println(result.getPrintString());

            } while(result != BaseBallGameResultType.THREE_STRIKE);

            gameFlag = gameEnd(scanner);
        } while (gameFlag);
    }

    private static List<Integer> getIntegers(Scanner scanner) {
        while (true) {
            try {
                return inputNumber(scanner);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 잘못 입력 했습니다. 다시 입력해 주세요.");
            }
        }
    }

    private static List<Integer> inputNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.next();

        List<Integer> numbers = new ArrayList<>();
        for(String number: input.split("")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static boolean gameEnd(Scanner scanner) {
        while (true) {
            try {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int input = scanner.nextInt();

                return input == 1;
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력 했습니다. 다시 입력해 주세요.");
            }
        }
    }
}
