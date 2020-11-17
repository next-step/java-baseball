package game.baseball.domain.service;

import game.baseball.domain.model.AnswerNumber;
import game.baseball.domain.model.BaseBallNumber;
import game.baseball.domain.model.BaseBallResult;
import game.baseball.domain.shared.BaseBallStatus;
import game.baseball.domain.model.InputNumber;

public class ResultJudgementService {

	public BaseBallResult judgeResult(InputNumber inputNumber, AnswerNumber answerNumber) {
		BaseBallResult result = new BaseBallResult();

		for (int inputIndex = 0; inputIndex < BaseBallNumber.NUMBERS_SIZE; inputIndex++) {
			int inputValue = inputNumber.get(inputIndex);
			Integer answerIndex = answerNumber.getIndex(inputValue);
			result.update(judgeStatus(inputIndex, answerIndex));
		}

		return result;
	}

	private BaseBallStatus judgeStatus(int inputIndex, Integer answerIndex) {
		if (answerIndex == null) {
			return BaseBallStatus.NOTTING;
		}

		if (answerIndex == inputIndex) {
			return BaseBallStatus.STRIKE;
		}

		return BaseBallStatus.BALL;
	}
}
