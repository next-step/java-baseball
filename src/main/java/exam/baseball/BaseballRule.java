package exam.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballRule {

	private String[] correctAnswers;
	public BaseballRule(String correctAnswer) {
		if (correctAnswer.length() != 3) {
			throw new IllegalArgumentException("CorrectAnswer must be of length 3.");
		}
		this.correctAnswers = correctAnswer.split("");
	}

	public Score checkPitching(String answer) {
		int strike = checkStrike(answer);
		int ball = strike != 3 ? checkBall(answer) : 0;
		return new Score(ball, strike);
	}

	int checkBall(String answer) {
		String[] splitted = answer.split("");
		int count = containsOtherPosition(correctAnswers, splitted, 0) ? 1 : 0;
		count += containsOtherPosition(correctAnswers, splitted, 1) ? 1 : 0;
		count += containsOtherPosition(correctAnswers, splitted, 2) ? 1 : 0;
		return count;
	}

	int checkStrike(String answer) {
		String[] splitted = answer.split("");
		int count = equalToSamePosition(correctAnswers, splitted, 0) ? 1 : 0;
		count += equalToSamePosition(correctAnswers, splitted, 1) ? 1 : 0;
		count += equalToSamePosition(correctAnswers, splitted, 2) ? 1 : 0;
		return count;
	}

	boolean equalToSamePosition(String[] corrects, String[] splitted, int position) {
		if (splitted[position].equals(corrects[position])) {
			return true;
		}
		return false;
	}

	boolean containsOtherPosition(String[] corrects, String[] splitted, int position) {
		List<String> correctsList = Arrays.asList(corrects);
		correctsList = new ArrayList<>(correctsList);
		correctsList.remove(position);
		if (correctsList.contains(splitted[position])) {
			return true;
		}
		return false;
	}

	public String makeHint(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}
		String hint = "";
		if (strike > 0) {
			hint += String.format("%d 스트라이크", strike);
		}
		if (ball > 0) {
			hint += String.format("%s%d 볼", (strike > 0 ? " " : ""), ball);
		}
		return hint;
	}
}
