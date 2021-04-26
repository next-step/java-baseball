package baseball.code;

public enum ScoreCode {
	NOTHING(0, 0, "낫싱"),
	ONE_BALL(1, 0, "1볼"),
	TWO_BALL(2, 0, "2볼"),
	THREE_BALL(3, 0, "3볼"),
	ONE_STRIKE(0, 1, "1 스트라이크"),
	ONE_STRIKE_ONE_BALL(1, 1, "1 스트라이크 1볼"),
	ONE_STRIKE_TWO_BALL(2, 1, "1 스트라이크 2볼"),
	TWO_STRIKE(0, 2, "2 스트라이크"),
	THREE_STRIKE(0, 3, "3 스트라이크");

	private int ball;
	private int strike;
	private String message;

	ScoreCode(int ball, int strike, String message) {
		this.ball = ball;
		this.strike = strike;
		this.message = message;
	}

	/**
	 * 스트라이크와 볼의 갯수가 일치하는 코드를 리턴한다.
	 * @param strike
	 * @param ball
	 * @return ScoreCode
	 */
	public static ScoreCode getScoreCode(int strike, int ball) {
		ScoreCode matchedCode = null;
		for (ScoreCode scoreCode : ScoreCode.values()) {
			matchedCode = (scoreCode.strike == strike && scoreCode.ball == ball) ? scoreCode : matchedCode;
		}
		return matchedCode;
	}

	/**
	 * 스코어 코드를 통해 결과를 출력한다.
	 * @param scoreCode
	 */
	public static void printScore(ScoreCode scoreCode) {
		System.out.println(scoreCode.message);
		if (ScoreCode.THREE_STRIKE == scoreCode) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}
}
