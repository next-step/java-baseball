import java.util.LinkedHashMap;
import java.util.Map;

public class Problem {

	private String answer;

	public Problem() {
		initNumber();
	}

	public Problem(String answer) {
		this.answer = answer;
	}

	public void initNumber() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int randomNumber = (int)(Math.random() * 9 + 1);
			builder.append(randomNumber);
		}

		this.answer = builder.toString();
	}

	public Map<Result, Integer> getResultMap(String input) {
		Map<Result, Integer> resultMap = new LinkedHashMap<>();

		for (int i = 0; i < input.length(); i++) {
			Result result = getResult(input, i);
			resultMap.putIfAbsent(result, 0);
			resultMap.computeIfPresent(result, (k, v) -> v + 1);
		}

		return resultMap;
	}

	private Result getResult(String input, int index) {
		if (answer.charAt(index) == input.charAt(index)) {
			return Result.STRIKE;
		}

		if (answer.contains(String.valueOf(input.charAt(index)))) {
			return Result.BALL;
		}

		return Result.NONE;
	}
}
