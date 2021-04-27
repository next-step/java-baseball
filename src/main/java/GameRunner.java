import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 숫자 야구 게임을 실행하기 위한 클래스
 */
public class GameRunner {

	public static void main(String[] args) {
		GameRunner gameRunner = new GameRunner();
		gameRunner.playNumberBaseBallGame();
	}

	public static void playNumberBaseBallGame() {
		Scanner scanner = new Scanner(System.in);
		int[] gameNumbers = generateNumberBaseballGame();
		int strike = 0;
		int ball = 0;

		do {
			System.out.print("숫자를 입력하세요 : ");
			int playerInput = Integer.parseInt(scanner.nextLine());
			int[] playerInputNumbers = playerInputNumbersToArray(playerInput);

			if (!PlayerInputValidator.validatePlayerNumbersLength(playerInputNumbers))
				break;
			if (!PlayerInputValidator.validatePlayerNumbersDuplicate(playerInputNumbers))
				break;

			strike = GameReferee.refereeStrike(playerInputNumbers, gameNumbers);
			ball = GameReferee.refereeBall(playerInputNumbers, gameNumbers);

			printCompareResult(strike, ball);
		} while (strike < 3);
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		}
		replayNumberBaseBallGame();
	}

	public static void printCompareResult(int strike, int ball) {
		String gameOutput = "";
		if (strike > 0)
			gameOutput += strike + " 스트라이크 ";

		if (ball > 0)
			gameOutput += ball + " 볼 ";

		if ("".equals(gameOutput))
			gameOutput += "낫싱";

		System.out.println(gameOutput);
	}

	public static void replayNumberBaseBallGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("게임을 새로하려면 1, 종료하려면 2를 입력하세요");

		int replay = scanner.nextInt();
		if (replay == 1) {
			playNumberBaseBallGame();
		}
	}

	public static int[] generateNumberBaseballGame() {
		Integer[] baseNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Collections.shuffle(Arrays.asList(baseNumbers));
		Integer[] pickNumbers = Arrays.copyOfRange(baseNumbers, 0, 3);

		int[] gameNumbers = new int[3];
		for (int i = 0; i < gameNumbers.length; i++) {
			gameNumbers[i] = pickNumbers[i];
		}
		return gameNumbers;
	}

	public static int[] playerInputNumbersToArray(int playerInput) {
		String numbers = String.valueOf(playerInput);
		int[] playerInputNumbers = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			playerInputNumbers[i] = Integer.parseInt(numbers.substring(i, i + 1));
		}
		return playerInputNumbers;
	}
}
