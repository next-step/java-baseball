public class BaseballGame {

	BaseballConsole console;
	BaseballUtils baseballUtils = new BaseballUtils();
	BaseballBallCount ballCount = new BaseballBallCount();

	private String answer = "";

	public BaseballGame(BaseballConsole console) {
		this.console = console;
	}

	public String getAnswer() {
		return answer;
	}

	public void playBall() {
		boolean morePitching = true;

		while(morePitching) {
			initGame();
			playGame();
			morePitching = requestMorePitching();
		}
	}

	public void initGame() {
		answer = baseballUtils.cerateAnswer();
	}

	public void playGame() {
		String attackKeyword;
		boolean isOut = false;
		while (!isOut) {
			attackKeyword = requestKeyword();
			isOut = callJudge(attackKeyword);
		}
	}

	public boolean requestMorePitching() {
		String pitchingCondition = console.getMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
		try {
			baseballUtils.chekckPitchingCondition(pitchingCondition);
		} catch (IllegalArgumentException iae) {
			console.setMessage(iae.getMessage());
			requestMorePitching();
		}
		return (pitchingCondition.equals("1") ? true : false);
	}

	private String requestKeyword() {
		String attackKeyword = null;
		boolean validFlag = false;

		while (!validFlag ) {
			attackKeyword = console.getMessage("숫자를 입력해주세요 : ");
			validFlag = inputStrValidate(attackKeyword);
		}
		return attackKeyword;
	}

	private boolean callJudge(String attackKeyword) {
		boolean outFlag = isOutCount(attackKeyword);
		if (outFlag) {
			console.setMessage("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return true;
		}

		console.setMessage(ballCount.getCallSign());
		return false;
	}

	private boolean isOutCount(String attackKeyword) {
		ballCount.setCallSign(answer, attackKeyword);
		return isOut();
	}

	private boolean isOut() {
		return ballCount.getStrikeCount() == answer.length();
	}

	private boolean inputStrValidate(String attackKeyword) {
		try {
			baseballUtils.checkEqualLength3(attackKeyword);
			baseballUtils.checkNumberType(attackKeyword);
			baseballUtils.checkIncludeZero(attackKeyword);
			baseballUtils.checkNotExistsDupNumbers(attackKeyword);
			return true;
		} catch (IllegalArgumentException iae) {
			console.setMessage(iae.getMessage());
			return false;
		}
	}
}
