package game.baseball.application;

import game.baseball.domain.model.InputNumber;
import game.baseball.domain.repository.AnswerNumberRepository;

public class BaseBallGameService {
	private final AnswerNumberRepository answerNumberRepository;

	public BaseBallGameService() {
		this.answerNumberRepository = new AnswerNumberRepository();
	}

	public void start() {
		answerNumberRepository.generate();
	}

	public void runRound(int input) {
		InputNumber inputNumber = InputNumber.generate(input);
	}
}
