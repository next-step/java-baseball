import java.util.Map;

public class BaseballGame {
	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		Display display = new Display();
		Problem problem = new Problem();

		do {
			display.print();
		} while (game.playGame(problem, display));
	}

	private boolean playGame(Problem problem, Display display) {
		Map<Result, Integer> resultMap = problem.getResultMap(display.input());
		display.print(resultMap);

		if (resultMap.getOrDefault(Result.STRIKE, -1) == 3) {
			return strike(problem, display.input());
		}

		return true;
	}

	private static boolean strike(Problem problem, String input) {
		if ("1".equals(input)) {
			problem.initNumber();
			return true;
		}

		return false;
	}
}
