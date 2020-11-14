import constants.Result;

public class ResultFactory {

	public static Result getResult(int strikeCount, int ballCount) {
		if (isThreeStrike(strikeCount))
			return Result.THREE_STRIKE;

		if (isNothing(strikeCount, ballCount))
			return Result.NOTING;

		Result result = Result.CONTINUE;
		result.setMessage(strikeCount + " 스트라이크 " + ballCount + " 볼");

		return result;
	}

	private static boolean isThreeStrike(int strike) {
		return ResultChecker.SUCCESS_COUNT == strike;
	}

	private static boolean isNothing(int strike, int ball) {
		return strike == 0 && ball == 0;
	}
}
