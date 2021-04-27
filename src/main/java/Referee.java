import java.util.HashMap;
import java.util.Map;

public class Referee {

	private final String question;
	private final String input;
	private Map<Result, Integer> score;

	public Referee(int question, String input) {
		this.question = String.valueOf(question);
		this.input = input;
		this.score = judge();
	}

	public boolean isFinish() {
		return score.containsKey(Result.STRIKE) && score.get(Result.STRIKE) == 3;
	}

	public Map<Result, Integer> getScore() {
		return score;
	}

	private Map<Result, Integer> judge() {
		Map<Result, Integer> score = new HashMap<>();
		for (int i = input.length() - 1; i >= 0; i--) {
			scoreResult(i, score);
		}
		return score;
	}

	private Map<Result, Integer> scoreResult(int i, Map<Result, Integer> score) {
		if (isStrike(question.charAt(i), input.charAt(i))) {
			calculateMap(Result.STRIKE, score);
			return score;
		}
		if (isBall(question, input.charAt(i))) {
			calculateMap(Result.BALL, score);
		}
		return score;
	}

	private void calculateMap(Result resultType, Map<Result, Integer> score) {
		score.putIfAbsent(resultType, 0);
		score.computeIfPresent(resultType, (k, v) -> v + 1);
	}

	private boolean isStrike(char question, char input) {
		return question == input;
	}

	private boolean isBall(String question, char input) {
		return question.contains(String.valueOf(input));
	}

}
