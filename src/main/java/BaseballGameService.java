import java.util.Random;

public class BaseballGameService {

	public int[] peek3RandomDistinctNumbers() {
		int[] peek = new int[3];
		boolean[] seen = new boolean[10];
		int pointer = 0;
		Random random = new Random();
		while (pointer < peek.length) {
			peek[pointer++] = peekDistinct(random, seen);
		}
		return peek;
	}

	public Hint getHint(int[] answer, String input) {
		int strike = findStrike(answer, input);
		int ball = findBall(answer, input);
		return new Hint(strike, ball);
	}

	private int peekDistinct(Random random, boolean[] seen) {
		int randomInt = random.nextInt(9) + 1;
		if (seen[randomInt]) {
			return peekDistinct(random, seen);
		}
		seen[randomInt] = true;
		return randomInt;
	}

	private int findBall(int[] answer, String input) {
		int ball = 0;
		int pointer = 0;
		while (pointer < answer.length) {
			int index = input.indexOf(intToChar(answer[pointer]));
			ball += (index == -1) || (index == pointer) ? 0 : 1;
			pointer++;
		}
		return ball;
	}

	private int findStrike(int[] answer, String input) {
		int strike = 0;
		int pointer = 0;
		while (pointer < answer.length) {
			strike += answer[pointer] == charToInt(input.charAt(pointer)) ? 1 : 0;
			pointer++;
		}
		return strike;
	}

	private char intToChar(int i) {
		return (char)(i + '0');
	}

	private int charToInt(char c) {
		return (int)c - '0';
	}
}
