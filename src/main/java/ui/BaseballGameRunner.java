package ui;

import domain.BaseballGame;
import domain.BaseballResult;
import domain.RandomBaseballNumbersGenerator;

import java.util.Scanner;

public class BaseballGameRunner {
    private static final String GAME_ENDING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BaseballGameTemplate.runBaseballGame(() -> {
            BaseballGame baseballGame = BaseballGame.init(new RandomBaseballNumbersGenerator());

            playOneRound(baseballGame);

            System.out.println(GAME_ENDING);
        });
    }

    private static void playOneRound(BaseballGame baseballGame) {
        while(!baseballGame.isFinished()) {
            System.out.println("숫자를 입력해주세요: ");
            UserInput userInput = new UserInput(scanner.nextLine());

            BaseballResult baseballResult = baseballGame.play(userInput.convertToBaseballNumbers());

            System.out.println(UserOutput.parseResult(baseballResult));
        }
    }
}
