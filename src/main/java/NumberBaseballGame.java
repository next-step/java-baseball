import java.util.Scanner;

import util.NumberBaseballGameGuessCalculator;
import util.NumberBaseballGameUiUtil;
import util.NumberBaseballGameNumbersGenerator;

public class NumberBaseballGame extends Game {
	@Override
	void launch() {
		Scanner sc = new Scanner(System.in);

		runARound(NumberBaseballGameNumbersGenerator.generateUniqueNumbers(3), sc);

		sc.close();
	}

	private void runARound(int[] targetNumbers, Scanner sc) {
		int strikeCount, ballCount = 0;

		do {
			int[] inputNumbers = NumberBaseballGameUiUtil.getUserInputNumber(sc);
			strikeCount = NumberBaseballGameGuessCalculator.calculateStrikeCount(targetNumbers, inputNumbers);
			ballCount = NumberBaseballGameGuessCalculator.calculateBallCount(targetNumbers, inputNumbers);
			NumberBaseballGameUiUtil.printGuessResult(strikeCount, ballCount);
		} while (strikeCount != 3);

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
