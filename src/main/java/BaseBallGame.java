import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BaseBallGame implements Game {
	@Override
	public void playGame() {

	}

	@Override
	public void endGame() {

	}

	@Override
	public void printMsg(String msg) {
		System.out.println(msg);
	}

	public LinkedHashSet<String> makeNumbers() {
		LinkedHashSet<String> numbers = new LinkedHashSet<>();
		while (numbers.size() < 3) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 9);
			numbers.add(String.valueOf(randomNum));
		}
		return numbers;
	}

	public String inputNumbers() {
		Scanner scan = new Scanner(System.in);
		String numbers = String.valueOf(scan.nextInt());
		scan.close();
		return numbers;
	}

	public boolean judgeGame(String numbers, String inputNumbers) {
		boolean result = false;
		int strike = callStrike(numbers, inputNumbers);
		int ball = callBall(numbers, inputNumbers);
		return result;
	}

	public int callStrike(String numbers, String inputNumbers) {
		int strike = 0;
		for (int i = 0; i < numbers.length(); i++) {
			strike += compareStrike(numbers.charAt(i), inputNumbers.charAt(i));
		}
		return strike;
	}

	public int compareStrike(char char1, char char2) {
		if (char1 == char2) {
			return 1;
		}
		return 0;
	}

	public int callBall(String numbers, String inputNumbers) {
		int ball = 0;

		return ball;
	}

	public int compareBall(char inputNumber, String numbers) {
		return 0;
	}
}
