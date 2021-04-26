package basballgame.game;

public class Computer {

	private final BaseballSet answer;

	public Computer(BaseballSet answer) {
		this.answer = answer;
	}

	public BaseballResult checkBaseballNumber(BaseballSet userInputBaseballSet) {
		int strike = getStrikeCountFrom(userInputBaseballSet);
		int ball = getBallCountFrom(userInputBaseballSet);
		return new BaseballResult(strike, ball);
	}

	private int getStrikeCountFrom(BaseballSet userInputBaseballSet) {
		int count = 0;

		if (this.answer.getFirst() == userInputBaseballSet.getFirst())
			count++;

		if (this.answer.getSecond() == userInputBaseballSet.getSecond())
			count++;

		if (this.answer.getThird() == userInputBaseballSet.getThird())
			count++;

		return count;
	}

	private  int getBallCountFrom(BaseballSet userInputBaseballSet) {
		int count = 0;
		if (this.answer.getSecond() == userInputBaseballSet.getFirst() || this.answer.getThird() == userInputBaseballSet.getFirst())
			count++;

		if (this.answer.getFirst() == userInputBaseballSet.getSecond() || this.answer.getThird() == userInputBaseballSet.getSecond())
			count++;

		if (this.answer.getFirst() == userInputBaseballSet.getThird() || this.answer.getSecond() == userInputBaseballSet.getThird())
			count++;

		return count;
	}

}

