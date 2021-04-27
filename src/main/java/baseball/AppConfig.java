package baseball;

import baseball.answer.AnswerService;
import baseball.answer.AnswerServiceImpl;
import baseball.judge.JudgeService;
import baseball.judge.JudgeServiceImpl;
import baseball.play.PlayService;
import baseball.play.PlayServiceImpl;
import baseball.question.QuestionService;
import baseball.question.QuestionServiceImpl;

public class AppConfig {

	public AnswerService answerService() {
		return new AnswerServiceImpl();
	}

	public QuestionService questionService() {
		return new QuestionServiceImpl();
	}

	public JudgeService judgeService() {
		return new JudgeServiceImpl();
	}

	public PlayService playService() {
		return new PlayServiceImpl(answerService(), questionService(), judgeService());
	}
}
