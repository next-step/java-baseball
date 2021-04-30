package baseball;

import baseball.judgment.Ball;
import baseball.judgment.JudgmentStrikeOrBall;
import baseball.judgment.JudgmentService;
import baseball.judgment.Strike;
import common.Constants;
import common.ShuffleNumbers;

public class BaseBallGame {
	private static final String[] NUMBERS = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private static final int MAX_LENGTH = 3;
	private static final String CONTINUE_GAME = "1";
	private String shuffledNumbers;

	public void setShuffledNumbers(String shuffledNumbers) {
		this.shuffledNumbers = shuffledNumbers;
	}

	public void runGame() {
		setShuffledNumbers(ShuffleNumbers.getShuffledThreeNumbers(NUMBERS, MAX_LENGTH));
		String userAnswer;

		do {
			userAnswer = UserInput.inputThreeNumbers();
		} while (!isCorrectAnswer(userAnswer) || isContinueGame(UserInput.inputContinueGame()));
	}

	public boolean isCorrectAnswer(String answer) {
		if (shuffledNumbers.equals(answer)) {
			System.out.println(MAX_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		} else if (Constants.INPUT_NUMBER_ERROR.equals(answer)) {
			return false;
		}
		makeHint(answer);
		return false;
	}

	public boolean isContinueGame(String answer) {
		if (CONTINUE_GAME.equals(answer)) {
			setShuffledNumbers(ShuffleNumbers.getShuffledThreeNumbers(NUMBERS, MAX_LENGTH));
			return true;
		}
		return false;
	}

	public void makeHint(String answer) {
		int strikeCnt = judgeStrikeOrBall(new Strike(), answer, shuffledNumbers);
		int ballCnt = judgeStrikeOrBall(new Ball(), answer, shuffledNumbers);
		printHint(strikeCnt, ballCnt);
	}

	private void printHint(int strikeCnt, int ballCnt) {
		if (strikeCnt > 0) {
			System.out.print(strikeCnt + " 스트라이크 ");
		}
		if (ballCnt > 0) {
			System.out.print(ballCnt + " 볼");
		}
		if (strikeCnt == 0 && ballCnt == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}

	public int judgeStrikeOrBall(JudgmentStrikeOrBall judgment, String answer, String numbers) {
		int cnt = 0;

		for (int i = 0; i < answer.length(); i++) {
			cnt += JudgmentService.judge(judgment, numbers.indexOf(String.valueOf(answer.charAt(i))), i);
		}

		return cnt;
	}

	public static void main(String[] args) {
		BaseBallGame bbg = new BaseBallGame();
		bbg.runGame();
	}

}
