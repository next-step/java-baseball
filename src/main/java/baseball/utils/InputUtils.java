package baseball.utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import baseball.domain.GameStatus;

public class InputUtils {
	private static final int NUMBER_LENGTH = 3;
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String GAMEOVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String QUESTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public InputUtils() {
	}

	public static int[] getNumber(final int min, final int max) {
		System.out.print(INPUT_MESSAGE);
		int answer = scanner.nextInt();

		int[] result = getResultArray(answer);

		checkValidLenth(result.length);
		checkValidRange(result, min, max);
		checkDuplicate(result);

		return result;
	}

	public static GameStatus getGameStatus() {
		System.out.println(GAMEOVER_MESSAGE);
		System.out.println(QUESTION_MESSAGE);

		int answer = scanner.nextInt();

		checkValidAnswer(answer);

		return chooseStatus(answer);
	}

	private static GameStatus chooseStatus(int answer) {
		if (answer == 2) {
			return GameStatus.GAMEOVER;
		}

		return GameStatus.NEW;
	}

	private static void checkValidAnswer(int answer) {
		if (answer != 1 && answer != 2) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}
	}

	public static void checkDuplicate(int[] result) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < NUMBER_LENGTH; i++) {
			set.add(result[i]);
		}

		checkValidLenth(set.size());
	}

	private static void checkValidLenth(int length) {
		if (length != NUMBER_LENGTH) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}
	}

	private static void checkValidRange(int[] number, int min, int max) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (number[i] < min) {
				throw new IllegalArgumentException("입력값이 잘못되었습니다.");
			}

			if (number[i] > max) {
				throw new IllegalArgumentException("입력값이 잘못되었습니다.");
			}
		}
	}

	private static int[] getResultArray(int answer) {
		String str = Integer.toString(answer);

		int[] result = new int[str.length()];

		for (int i = 0; i < result.length; i++) {
			result[i] = str.charAt(i) - '0';
		}

		return result;
	}
}
