import java.util.Map;

public class BaseballGame {
	public void printResult(Map<Result, Integer> resultMap) {
		StringBuilder sb = new StringBuilder();

		resultMap.forEach((result, count) -> {
			sb.append(resultToString(result, count));
		});

		if (sb.length() == 0) {
			sb.append("낫싱");
		}

		System.out.println(sb.toString().trim());
	}

	private String resultToString(Result result, Integer count) {
		if (result == Result.STRIKE) {
			return String.format("%d, %s ", count, "스트라이크");
		}

		if (result == Result.BALL) {
			return String.format("%d, %s ", count, "볼");
		}

		throw new IllegalArgumentException(String.format("Result value [%s] is invalid", result));
	}
}
