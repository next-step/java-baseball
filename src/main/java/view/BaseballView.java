package view;

import application.BaseballService;
import domain.BaseballNumbers;
import domain.Score;

import java.util.Scanner;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임 UI
 **/
public class BaseballView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUIRE_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_OVER_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RETRY_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static BaseballService baseballService;

    public static void start() {
        boolean isGameEnd = false;
        baseballService = new BaseballService();

        while (!isGameEnd) {
            BaseballNumbers answer = baseballService.generateAnswer();
            String playerBaseballNumber = requirePlayerBaseballNumber();
            Score score = baseballService.checkBaseballNumber(playerBaseballNumber, answer);
            printScore(score);
            isGameEnd = isGameOver(score);
        }
        askRetry();
    }

    private static void askRetry() {
        System.out.println(ASK_RETRY_GAME_MESSAGE);
    }

    private static boolean isGameOver(Score score) {
        return score.isAllStrike();
    }

    private static void printScore(Score score) {
        combinePrintScoreMessage(score);
        if (score.isNothing()) System.out.println(NOTHING_MESSAGE);
        if (score.isAllStrike()) System.out.println(BaseballNumbers.NUMBER_OF_BASEBALL_GAME + GAME_OVER_MESSAGE);
    }

    private static void combinePrintScoreMessage(Score score) {
        StringBuilder sb = new StringBuilder();
        if (score.getStrike() != 0) {
            sb.append(score.getStrike()).append(" ").append(STRIKE_MESSAGE);
        }

        if (score.getBall() != 0) {
            sb.append(" ").append(score.getBall()).append(" ").append(BALL_MESSAGE);
        }
        String message = sb.toString().replaceAll("^\\s+", "");
        if (!message.isEmpty()) System.out.println(message);
    }

    private static String requirePlayerBaseballNumber() {
        System.out.print(REQUIRE_NUMBER_MESSAGE);
        return scanner.next();
    }
}
