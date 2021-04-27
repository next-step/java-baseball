import services.Evaluation;
import services.ProblemNumberGenerator;
import views.InputView;
import views.OutputView;

import java.util.List;

public class GameRunner {
	private final InputView inputView;
	private final OutputView outputView;
	private final ProblemNumberGenerator problemNumberGenerator;

	public GameRunner() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.problemNumberGenerator = new ProblemNumberGenerator();
	}

	public void play() {
		List<Integer> problemNumber = problemNumberGenerator.generate();
		Evaluation evaluation = new Evaluation();

		while (!evaluation.doesHitAnswer()) {
			evaluation.evaluate(inputView.inputAnswerNumber(), problemNumber);
			outputView.printEvaluation(evaluation.getStrikeCount(), evaluation.getBallCount());
		}
		handleGameMenu();
	}

	private void handleGameMenu() {
		int selectedNumber = inputView.selectGameMenu();

		if (GameMenuEnum.doesRestart(selectedNumber)) {
			play();
		}
	}
}
