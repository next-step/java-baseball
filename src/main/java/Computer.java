import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Computer {
	private List<Integer> computerNumbers;
	private int strikeCount;
	private int ballCount;

	public int getStrikeCount() {
		return strikeCount;
	}

	public void generateNumbers() {
		Set<Integer> selectNumbers = new HashSet<>();
		Random random = new Random();

		while (selectNumbers.size() < 3) {
			selectNumbers.add(random.nextInt(9));
		}

		computerNumbers = new ArrayList<>(selectNumbers);
	}

	public void matchResult(List<Integer> userNumbers) {
		System.out.println(computerNumbers);
		countStrike(userNumbers);
		countBall(userNumbers);
	}

	public void countStrike(List<Integer> userNumbers) {
		for (int i = 0; i < userNumbers.size(); i++) {
			strikeCount += matchStrikeNumber(computerNumbers.get(i), userNumbers.get(i));
		}
	}

	public void countBall(List<Integer> userNumbers) {
		for (int i = 0; i < userNumbers.size(); i++) {
			ballCount += matchBallNumber(computerNumbers.get(i), userNumbers.get(i));
		}
	}

	public int matchStrikeNumber(int comNum, int userNum) {
		if (comNum == userNum) {
			return 1;
		}
		return 0;
	}

	public int matchBallNumber(int comNum, int userNum) {
		if (comNum == userNum) {
			return 0;
		}
		if (computerNumbers.contains(userNum)) {
			return 1;
		}
		return 0;
	}

	public void showHint() {
		System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
	}
}
