package domain;

import util.Referee;

public class Baseball {
	public static void main(String[] args) {
		Baseball.startGame();
	}

	public static void startGame() {
		boolean determination = true;
		// 세 자리 난수(게임문제) 생성
		String targetNumber = Computer.generateNumber();

		// 사용자로부터 답을 입력받고 결과확인
		while (determination) {
			String answerNumber = User.getUserAnswer();
			determination = checkResult(answerNumber, targetNumber);
		}

		// 게임 재시작 여부 확인
		if ("1".equals(User.getUserRetry())) {
			Baseball.startGame();
		}
	}

	// 사용자에게 입력받은 값과 비교한다
	public static boolean checkResult(String answerNumber, String targetNumber) {
		// 첫 번째 배열값은 스트라이크, 두 번째 배열값은 볼의 갯수를 나타내는 변수
		int[] checkArray = new int[2];

		for (int i = 0; i < answerNumber.length(); i++) {
			checkArray[0] += Referee.isStrike(i, answerNumber, targetNumber);
			checkArray[1] += Referee.isBall(i, answerNumber, targetNumber);
		}

		System.out.println(Referee.refereeDecision(checkArray));
		return checkArray[0] != 3;
	}
}
