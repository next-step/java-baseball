import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class BaseBallGame {
	public static final int GameContinueCode = 1;
	public static final int GameExitCode = 2;
	private static final String InputNumbersForUser = "숫자를 입력해주세요 : ";
	private static final String GameContinueOrExit = "게임을 새로 시작하려면1, 종료하려면 2를 입력하세요";
	private static final String AnswerAndExit = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
	private static final String Strike = " 스트라이크";
	private static final String Ball = "볼";
	private static final String Nothing = "낫씽";

	public static int getRandomNumber() {
		return new Random().nextInt(9) + 1;
	}

	public static int[] getRandomNumber3Length() {
		int[] targetNumber = new int[3];

		int count = 0;
		while (count < 3) {
			count = createRandomNumber3Length(targetNumber, count);
		}

		return targetNumber;
	}

	private static int createRandomNumber3Length(int[] target, int count) {
		int number = getRandomNumber();
		if (!ArrayUtils.contains(target, number)) {
			target[count] = number;
			count++;
		}
		return count;
	}

	public static int getStrikeCount(int[] target, int[] inputNumbers) {
		int strike = 0;
		for (int i = 0; i < target.length; i++) {
			strike = getStrikeCountCondition(target[i], inputNumbers[i], strike);
		}
		return strike;
	}

	private static int getStrikeCountCondition(int target, int inputNumber, int count) {
		return (target == inputNumber) ? count + 1 : count;
	}

	public static int getBallCount(int[] target, int[] inputNumbers) {
		int ball = 0;
		for (int i = 0; i < inputNumbers.length; i++) {
			ball = getBallCountCondition(target, inputNumbers, i, ball);
		}
		return ball;
	}

	private static int getBallCountCondition(int[] target, int[] inputNumbers, int index, int count) {
		return (ArrayUtils.indexOf(target, inputNumbers[index]) > -1 && target[index] != inputNumbers[index])
			? count + 1 : count;
	}

	private static int[] getUserInputNumbers() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(InputNumbersForUser);
		String userInput = scanner.nextLine();
		String[] userInputStringArray = userInput.split("");
		int len = userInputStringArray.length;
		int[] userInputNumbers = new int[len];
		for (int i = 0; i < len; i++) {
			userInputNumbers[i] = Integer.parseInt(userInputStringArray[i]);
		}
		return userInputNumbers;
	}

	public static int getGameCode() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(GameContinueOrExit);
		return scanner.nextInt();
	}

	private static void printStrikeAndBall(int strike, int ball) {
		if (strike > 0) {
			System.out.print(strike + Strike);
		}
		if (ball > 0) {
			System.out.print(ball + Ball);
		}
		if (strike == 0 && ball == 0) {
			System.out.print(Nothing);
		}
		System.out.println();
		if (strike == 3) {
			System.out.println(AnswerAndExit);
		}
	}

	public static void start(int[] target) {
		int strike = 0;
		int ball = 0;
		while (strike < 3) {
			// 사용자 입력
			int[] userInputNumbers = getUserInputNumbers();
			// 스트라이크/볼 확인
			strike = getStrikeCount(target, userInputNumbers);
			ball = getBallCount(target, userInputNumbers);
			printStrikeAndBall(strike, ball);
		}
	}
}