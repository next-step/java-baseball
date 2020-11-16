package game.baseball.application;

import game.baseball.domain.repository.AnswerNumberRepository;

public class BaseBallGameService {
	private final AnswerNumberRepository answerNumberRepository;

	public BaseBallGameService() {
		this.answerNumberRepository = new AnswerNumberRepository();
	}

	public void start() {
		answerNumberRepository.generate();
	}
}
