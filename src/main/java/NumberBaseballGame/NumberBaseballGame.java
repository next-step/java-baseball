package NumberBaseballGame;

import java.util.ArrayList;
import java.util.List;
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

	public BallCount judgeBallCount(int[] inputData) {
		List<BallCount> ballCountList = new ArrayList<BallCount>();
		BallCount ballCountSum = new BallCount();

		for (int i = 0; i < 3; i++) {
			ballCountList.add(checkBallCount(i, inputData[i]));
		}

		for (int i = 0; i < ballCountList.size(); i++) {
			ballCountSum.addStrikeCount(ballCountList.get(i).getStrike());
			ballCountSum.addBallCount(ballCountList.get(i).getBall());
		}

		return ballCountSum;
	}

	public BallCount checkBallCount(int index, int value) {
		BallCount ballCount = new BallCount();

		for (int j = 0; j < 3; j++) {
			ballCount.checkStrike(index, value, j, answer.getAnswer()[j]);
			ballCount.checkBall(index, value, j, answer.getAnswer()[j]);
		}

		return ballCount;
	}

	public void printBallCount(BallCount ballCount) {
		if (ballCount.getStrike() != 0) {
			System.out.print(ballCount.getStrike() + " 스트라이크    ");
		}
		if (ballCount.getBall() != 0) {
			System.out.print(ballCount.getBall() + " 볼 ");
		}
		if (ballCount.getStrike() + ballCount.getBall() == 0) {
			System.out.print("낫씽");
		}
		System.out.print("\n");
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
