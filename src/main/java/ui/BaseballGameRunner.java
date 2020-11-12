package ui;

import domain.BaseballGame;
import domain.BaseballResult;
import domain.RandomBaseballNumbersGenerator;

import java.util.Scanner;

public class BaseballGameRunner {
    private static final String GAME_ENDING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        BaseballGameTemplate.runBaseballGame(() -> {
            GameLatch gameLatch = GameLatch.of();
            while (gameLatch.isContinued()) {
                BaseballGame baseballGame = BaseballGame.init(new RandomBaseballNumbersGenerator());

                playOneRound(baseballGame);

                System.out.println(GAME_ENDING);

                gameLatch.judgeKeepGoing(SCANNER.nextLine());
            }
        });
    }

    private static void playOneRound(BaseballGame baseballGame) {
        while(!baseballGame.isFinished()) {
            System.out.print("숫자를 입력해주세요: ");
            UserInput userInput = new UserInput(SCANNER.nextLine());

            BaseballResult baseballResult = baseballGame.play(userInput.convertToBaseballNumbers());

            System.out.println(UserOutput.parseResult(baseballResult));
        }
    }
}
