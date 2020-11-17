package game.baseball.application;

import game.baseball.domain.model.AnswerNumber;
import game.baseball.domain.model.BaseBallResult;
import game.baseball.domain.model.InputNumber;
import game.baseball.domain.repository.AnswerNumberRepository;
import game.baseball.domain.service.ResultJudgementService;

public class BaseBallGameService {
	private final AnswerNumberRepository answerNumberRepository;
	private final ResultJudgementService resultJudgementService;

	public BaseBallGameService() {
		this.answerNumberRepository = new AnswerNumberRepository();
		this.resultJudgementService = new ResultJudgementService();
	}

	public void start() {
		answerNumberRepository.generate();
	}

	public BaseBallResult runRound(int input) {
		InputNumber inputNumber = InputNumber.generate(input);
		AnswerNumber answerNumber = answerNumberRepository.getAnswerNumber();

		return resultJudgementService.judgeResult(inputNumber, answerNumber);
	}
}
