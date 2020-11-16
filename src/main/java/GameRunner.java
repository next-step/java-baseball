import services.AnswerNumberEvaluator;
import services.Evaluation;
import services.ProblemNumberGenerator;

import java.util.List;

public class GameRunner {
	private final View view;
	private final AnswerNumberEvaluator answerNumberEvaluator;
	private final ProblemNumberGenerator problemNumberGenerator;

	public GameRunner() {
		this.view = new View();
		this.answerNumberEvaluator = new AnswerNumberEvaluator();
		this.problemNumberGenerator = new ProblemNumberGenerator();
	}

	public void run() {
		List<Integer> problemNumber = problemNumberGenerator.generate();
		Evaluation evaluation = new Evaluation();

		while (!evaluation.doesHitAnswer()) {
			evaluation = answerNumberEvaluator.evaluate(view.inputAnswerNumber(), problemNumber);
			view.printEvaluation(evaluation.getStrikeCount(), evaluation.getBallCount());
		}
		handleGameMenu();
	}

	private void handleGameMenu() {
		int selectedNumber = view.selectGameMenu();

		if (selectedNumber == 1) {
			run();
		}
	}
}
