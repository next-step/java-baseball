import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BaseBallGame implements Game {
	@Override
	public void playGame() {
		LinkedHashSet<String> numbers = makeNumbers();
		String stringNumbers = linkedHashSetToString(numbers);
		String inputNumbers = inputNumbers("숫자를 입력해주세요 : ");
		while (!judgeGame(stringNumbers, inputNumbers)) {
			inputNumbers = inputNumbers("숫자를 입력해주세요 : ");
		}
		endGame();
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

	public String inputNumbers(String msg) {
		if (msg != null && msg.length() > 0) {
			printMsg(msg);
		}
		Scanner scan = new Scanner(System.in);
		String numbers = String.valueOf(scan.nextInt());
		return numbers;
	}

	public boolean judgeGame(String numbers, String inputNumbers) {
		boolean result = false;
		int strike = callStrike(numbers, inputNumbers);
		int ball = callBall(numbers, inputNumbers);
		printMsg(makeGameResult(strike, ball));
		if (strike == 3) {
			result = true;
		}
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
		for (int i = 0; i < inputNumbers.length(); i++) {
			ball += compareBall(inputNumbers.charAt(i), numbers, i);
		}
		return ball;
	}

	public int compareBall(char inputNumber, String numbers, int index) {
		if (numbers.indexOf(String.valueOf(inputNumber)) == index) {
			return 0;
		}
		if (numbers.contains(String.valueOf(inputNumber))) {
			return 1;
		}
		return 0;
	}

	public String makeGameResult(int strike, int ball) {
		String msg = "";
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}
		if (strike > 0) {
			msg += strike + " 스트라이크 ";
		}
		if (ball > 0) {
			msg += ball + " 볼 ";
		}
		return msg;
	}

	public String linkedHashSetToString(LinkedHashSet<String> numbers) {
		StringBuilder sb = new StringBuilder();
		for (String number : numbers) {
			sb.append(number);
		}
		return sb.toString();
	}
}
