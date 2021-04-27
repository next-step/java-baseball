package baseball.service.output;

import baseball.model.Baseball;
import baseball.model.BaseballResult;

public class ResultOutputService {
	public static String STRIKE = "스트라이크";
	public static String BALL = "볼";
	public static String NOTHING = "낫싱";
	public static String FINISH = "개의 숫자를 모두 맞히셨습니다! 게임종료";

	public void printResult(BaseballResult result) {
		StringBuilder stringBuilder = new StringBuilder();

		if (result.hasStrike()) {
			stringBuilder.append(result.getStrikeCount()).append(" ").append(STRIKE).append(" ");
		}

		if (result.hasBall()) {
			stringBuilder.append(result.getBallCount()).append(" ").append(BALL);
		}

		if (result.isNothing()) {
			stringBuilder.append(NOTHING);
		}

		System.out.println(stringBuilder);
	}

	public void printFinish() {
		System.out.printf("%d %s%n", Baseball.ANSWER_SIZE, FINISH);
	}
}
