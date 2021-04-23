package baseball;

import baseball.answer.AnswerService;
import baseball.answer.AnswerServiceImpl;
import baseball.play.PlayService;
import baseball.play.PlayServiceImpl;

public class AppConfig {

	public AnswerService answerService() {
		return new AnswerServiceImpl();
	}

	public PlayService playService() {
		return new PlayServiceImpl(answerService());
	}
}
