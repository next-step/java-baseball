package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {
	private enum Command { START, CONTINUE, FINISH }
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int SIZE_OF_NUMBERS = 3;
	private BallCount ballCount;
	List<Integer> answerNumbers;

	public Baseball() {
		ballCount = new BallCount();
		answerNumbers = new ArrayList<>();
		while (answerNumbers.size() < SIZE_OF_NUMBERS) {
			makeUniqueAnswerNumber();
		}
	}

	private void makeUniqueAnswerNumber() {
		Random rand = new Random();
		int number = rand.nextInt(MAX_NUMBER) + MIN_NUMBER;
		if (answerNumbers.contains(number)) {
			return;
		}
		answerNumbers.add(number);
	}

	void setAnswerNumbers(List<Integer> value) {
		answerNumbers = value;
	}

	public boolean checkAnswer(List<Integer> numbers) {
		ballCount = new BallCount();
		for (int i = 0; i < numbers.size(); i++) {
			int number = numbers.get(i);
			ballCount.add(getBallCountFromNumber(number, i));
		}
		return ballCount.getStrike() == SIZE_OF_NUMBERS;
	}

	private BallCount getBallCountFromNumber(int number, int idx) {
		BallCount ballCount = new BallCount();
		if (answerNumbers.contains(number) && answerNumbers.get(idx) == number) {
			ballCount.setStrike(ballCount.getStrike() + 1);
		} else if (answerNumbers.contains(number) && answerNumbers.get(idx) != number) {
			ballCount.setBall(ballCount.getBall() + 1);
		}
		return ballCount;
	}

	public void printBallCount() {
		int strike = ballCount.getStrike();
		int ball = ballCount.getBall();
		String ballCountString = "낫싱";
		if (strike > 0 && ball > 0) {
			ballCountString = String.format("%d 스트라이크 %d볼", strike, ball);
		} else if (strike > 0 && ball == 0) {
			ballCountString = String.format("%d 스트라이크", strike);
		} else if (strike == 0 && ball > 0) {
			ballCountString = String.format("%d볼", ball);
		}
		System.out.println(ballCountString);
	}

	private void playGameLoop() {
		boolean isCorrectAnswer = false;
		while (!isCorrectAnswer) {
			isCorrectAnswer = playGameRound();
		}
	}

	private boolean playGameRound() {
		boolean isCorrectAnswer;
		System.out.print("숫자를 입력해주세요: ");
		String input = ScannerUtil.getInstance().next();
		isCorrectAnswer = checkAnswer(Utils.stringToIntegerList(input));
		printBallCount();
		if (isCorrectAnswer) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		}
		return isCorrectAnswer;
	}

	public static void main(String[] args) {
		Command command = Command.START;
		while (command != Command.FINISH) {
			Baseball baseball = new Baseball();
			baseball.playGameLoop();
			command = Command.values()[ScannerUtil.getInstance().nextInt()];
		}
	}
}
