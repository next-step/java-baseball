package NumberBaseballGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumberBaseballGame {

	private Integer[] answer;
	Scanner scanner;

	public NumberBaseballGame() {
		answer = new Integer[3];
		scanner = new Scanner(System.in);
	}

	public void setAnswer() {
		Integer[] numArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> numList = new ArrayList<Integer>(Arrays.asList(numArray));
		int randomIndex = 0;

		for (int i = 0; i < 3; i++) {
			randomIndex = (int)(Math.random() * (numList.size()));
			answer[i] = numList.get(randomIndex);
			numList.remove(randomIndex);
		}

		System.out.println(answer[0] + ":" + answer[1] + ":" + answer[2]);
	}

	public void setAnswer(int firstValue, int secondValue, int thirdValue) {
		answer[0] = firstValue;
		answer[1] = secondValue;
		answer[2] = thirdValue;
	}

	public int[] writeInputDate() {
		String scData = "";

		do {
			System.out.print("숫자를 입력하세요 : ");
			scData = scanner.next();
		} while (!isValidInputData(scData));

		return splitInputData(scData);
	}

	public boolean isValidInputData(String scData) {
		if (scData.length() != 3) {
			System.out.println("세자리 숫자를 입력해야합니다");
			return false;
		}
		if (!scData.matches("^[1-9]+$")) {
			System.out.println("1~9 숫자만 입력해야합니다");
			return false;
		}
		if (isDuplicateInput(scData)) {
			System.out.println("중복된 숫자를 입력했습니다");
			return false;
		}
		return true;
	}

	public boolean isDuplicateInput(String scData) {
		String[] scDataToken = scData.split("(?!^)");

		for (int i = 0; i < 3; i++) {
			if (containsCount(scData, scDataToken[i]) > 1) {
				return true;
			}
		}

		return false;
	}

	public int containsCount(String scData, String scDataToken) {
		int count = scData.length() - scData.replace(scDataToken, "").length();
		return count;
	}

	public int[] splitInputData(String scData) {
		String[] scDataToken = scData.split("(?!^)");
		int[] inputData = new int[3];

		for (int i = 0; i < 3; i++) {
			inputData[i] = Integer.parseInt(scDataToken[i]);
		}

		return inputData;
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
			ballCount.checkStrike(index, value, j, answer[j]);
			ballCount.checkBall(index, value, j, answer[j]);
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
