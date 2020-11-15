package baseballgame;

import java.util.Scanner;

public class BaseballGameExcutor {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        RandomNumber randomNumber = generator.generateRandomNumber();
        Scanner scanner = new Scanner(System.in);

        ResultType result = ResultType.NOTHING;
        while (result != ResultType.THREE_STRIKE) {
            InputNumber inputNumber = requestInput(scanner);
            result = getmatchResult(randomNumber, inputNumber);
            System.out.println(result.getResultString());
        }
        finishGame(scanner);
    }

    private static void finishGame(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int finishCode = scanner.nextInt();
        if(finishCode == FinishCode.FINISH.getCode()) {
            return;
        }
        if(finishCode == FinishCode.NEW_GAME.getCode()) {
            playGame();
        }
    }

    private static ResultType getmatchResult(RandomNumber randomNumber, InputNumber inputNumber) {
        NumberMatcher matcher = new NumberMatcher();
        ResultType result = matcher.match(randomNumber, inputNumber);
        return result;
    }

    private static InputNumber convertNumber(String input) {
        InputNumberConverter converter = new InputNumberConverter();
        return converter.convertToInputNumber(input);
    }

    private static InputNumber requestInput(Scanner scanner) {
        while(true) {
            System.out.println("숫자를 입력해주세요");
            String next = scanner.next();
            try {
                return convertNumber(next);
            } catch (InputNumberValidException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
