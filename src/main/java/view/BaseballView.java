package view;

import static utils.BusinessException.*;

import java.util.Scanner;

import application.BaseballService;
import domain.BaseballNumbers;
import domain.Score;
import domain.enums.RetryType;

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
		BaseballNumbers answer = baseballService.generateAnswer();
		while (!isGameEnd) {
			String playerBaseballNumber = requirePlayerBaseballNumber();
			boolean isCorrectAnswer = checkBaseballNumber(playerBaseballNumber, answer);
			isGameEnd = isGameOver(isCorrectAnswer);
			reGenerateAnswer(answer, isCorrectAnswer, isGameEnd);
		}
	}

	private static BaseballNumbers reGenerateAnswer(BaseballNumbers answer, boolean isCorrectAnswer,
		boolean isGameEnd) {
		if (isCorrectAnswer && !isGameEnd) {
			answer = baseballService.generateAnswer();
		}
		return answer;
	}

	private static boolean isGameOver(boolean correctAnswer) {
		String retryCode = "";
		if (correctAnswer) {
			retryCode = askRetry();
		}
		if (correctAnswer && (RetryType.EXIT.getCode().equals(retryCode))) {
			return true;
		}
		if (correctAnswer && (RetryType.NEW_GAME.getCode().equals(retryCode))) {
			return false;
		}
		throw new ChooseRetryNumberException();
	}

	private static boolean checkBaseballNumber(String playerBaseballNumber, BaseballNumbers answer) {
		Score score = baseballService.checkBaseballNumber(playerBaseballNumber, answer);
		printScore(score);
		return isCorrectNumber(score);
	}

	private static String askRetry() {
		System.out.println(ASK_RETRY_GAME_MESSAGE);
		return scanner.next();

	}

	private static boolean isCorrectNumber(Score score) {
		return score.isAllStrike();
	}

	private static void printScore(Score score) {
		printCombineScoreMessage(score);
		if (score.isNothing())
			System.out.println(NOTHING_MESSAGE);
		if (score.isAllStrike())
			System.out.println(BaseballNumbers.NUMBER_OF_BASEBALL_GAME + GAME_OVER_MESSAGE);
	}

	private static void printCombineScoreMessage(Score score) {
		StringBuilder sb = new StringBuilder();
		if (score.getStrike() != 0) {
			sb.append(score.getStrike()).append(" ").append(STRIKE_MESSAGE);
		}

		if (score.getBall() != 0) {
			sb.append(" ").append(score.getBall()).append(" ").append(BALL_MESSAGE);
		}
		String message = sb.toString().replaceAll("^\\s+", "");
		if (!message.isEmpty())
			System.out.println(message);
	}

	private static String requirePlayerBaseballNumber() {
		System.out.print(REQUIRE_NUMBER_MESSAGE);
		return scanner.next();
	}
}
