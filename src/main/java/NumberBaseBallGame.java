import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberBaseBallGame {

	public static void main(String[] args) {
		playNumberBaseBallGame();
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

			if (!validatePlayerNumbersLength(playerInputNumbers)) break;
			if (!validatePlayerNumbersDuplicate(playerInputNumbers)) break;

			strike = checkStrike(playerInputNumbers, gameNumbers);
			ball = checkBall(playerInputNumbers, gameNumbers);

			StringBuffer gameOutput = new StringBuffer();
			if (strike > 0) {
				gameOutput.append(strike);
				gameOutput.append(" 스트라이크 ");
			}

			if (ball > 0) {
				gameOutput.append(ball);
				gameOutput.append(" 볼");
			}

			if (gameOutput.isEmpty()) {
				gameOutput.append("낫싱");
			}

			System.out.println(gameOutput.toString());
		} while (strike < 3);
		if( strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		}

		System.out.println("게임을 새로하려면 1, 종료하려면 2를 입력하세요");

		int regameInput = scanner.nextInt();
		if (regameInput == 1) {
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

	public static boolean validatePlayerNumbersLength(int[] playerInputNumbers) {
		if (playerInputNumbers.length < 3){
			System.out.println("입력된 숫자가 너무 많습니다. 3자리를 입력해 주세요.");
			return false;
		}
		return true;
	}

	public static boolean validatePlayerNumbersDuplicate(int[] playerInputNumbers) {
		Set<Integer> duplicateRemovedGameNumbers = new HashSet<>();
		for (int playerInputNumber : playerInputNumbers) {
			duplicateRemovedGameNumbers.add(playerInputNumber);
		}

		if (duplicateRemovedGameNumbers.size() < 3){
			System.out.println("중복된 숫자가 있습니다. 중복되지 않는 숫자를 입력하세요.");
			return false;
		}

		return true;
	}

	public static int[] playerInputNumbersToArray(int playerInput) {
		String numbers = String.valueOf(playerInput);
		int[] playerInputNumbers = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			playerInputNumbers[i] = Integer.parseInt(numbers.substring(i, i + 1));
		}
		return playerInputNumbers;
	}

	public static int checkStrike(int[] playerInputNumbers, int[] gameNumbers) {
		int strike = 0;
		for (int i = 0; i < playerInputNumbers.length; i++) {
			if (playerInputNumbers[i] == gameNumbers[i]) {
				strike++;
			}
		}
		return strike;
	}

	public static int checkBall(int[] playerInputNumbers, int[] gameNumbers) {
		int ball = 0;
		for (int i = 0; i < playerInputNumbers.length; i++) {
			for (int j = 0; j < gameNumbers.length; j++) {
				if (playerInputNumbers[i] == gameNumbers[j] && i != j) {
					ball++;
				}
			}
		}
		return ball;
	}
}
