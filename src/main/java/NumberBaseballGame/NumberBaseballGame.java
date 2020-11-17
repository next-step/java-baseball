package NumberBaseballGame;

import java.util.Scanner;

public class NumberBaseballGame {

	Answer answer;
	Scanner scanner;

	public NumberBaseballGame() {
		answer = new Answer();
		scanner = new Scanner(System.in);
	}

	public NumberBaseballGame(int firstValue, int secondValue, int thirdValue) {
		answer = new Answer(firstValue, secondValue, thirdValue);
	}

	public int[] getInputDate() {
		InputData inputData = new InputData();
		return inputData.getInputDate();
	}

	public BallCount getJudgment(int[] inputData) {
		BallCountJudgment judgment = new BallCountJudgment(inputData, answer);
		judgment.judgeBallCount();
		judgment.printBallCount();
		return judgment.getBallCountJudgment();
	}

	public boolean isEndGame(BallCount ballCount) {
		if (ballCount.getStrike() != 3) {
			return true;
		}

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		return false;
	}

	public boolean isRestartGame() {
		String progressFlg = "";

		while (!progressFlg.equals("1") && !progressFlg.equals("2")) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			progressFlg = scanner.next();
		}

		if (progressFlg.equals("1")) {
			return true;
		}
		if (progressFlg.equals("2")) {
			System.exit(0);
		}

		return false;
	}
}
