package basballgame.game;

import java.util.function.Supplier;

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

	private int getStrikeCountFrom(BaseballSet userSet) {
		int count = 0;
		count = isStrike(answer::getFirst, userSet::getFirst) 	? count + 1 : count;
		count = isStrike(answer::getSecond, userSet::getSecond) ? count + 1 : count;
		count = isStrike(answer::getThird, userSet::getThird)   ? count + 1 : count;
		return count;
	}

	private  int getBallCountFrom(BaseballSet userSet) {
		int count = 0;
		count = isBall(userSet::getFirst, answer::getSecond, answer::getThird) ? count + 1 : count;
		count = isBall(userSet::getSecond, answer::getFirst, answer::getThird) ? count + 1 : count;
		count = isBall(userSet::getThird, answer::getFirst, answer::getSecond) ? count + 1 : count;
		return count;
	}

	private boolean isStrike(Supplier<Integer> answerSet, Supplier<Integer> userSet) {
		return answerSet.get().equals(userSet.get());
	}

	private boolean isBall(Supplier<Integer> userSet, Supplier<Integer> answerSet1, Supplier<Integer> answerSet2) {
		return userSet.get().equals(answerSet1.get()) || userSet.get().equals(answerSet2.get());
	}
}