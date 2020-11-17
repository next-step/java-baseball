package game.baseball.domain.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import game.baseball.domain.model.AnswerNumber;
import game.baseball.domain.model.AnswerNumberTestHelper;
import game.baseball.domain.model.BaseBallResult;
import game.baseball.domain.model.InputNumber;
import game.baseball.domain.shared.NumberUtils;

class ResultJudgementServiceTest {

	@ParameterizedTest
	@CsvSource({"567,567,3,0", "567,569,2,0", "567,579,1,1", "567,759,0,2", "567,123,0,0"})
	@DisplayName("judgeResult()으로 잘 판단하는지 확인한다.")
	void judgeResultReturnThreeStrike(int answer, int input, int strike, int ball) {
		InputNumber inputNumber = InputNumber.generate(input);
		List<Integer> numbers = NumberUtils.split(answer);
		AnswerNumber answerNumber = AnswerNumberTestHelper.generateAnswerNumber(numbers,
			NumberUtils.createNumberIndexMap(numbers));
		ResultJudgementService resultJudgementService = new ResultJudgementService();

		BaseBallResult result = resultJudgementService.judgeResult(inputNumber, answerNumber);

		assertThat(result.getStrike())
			.isEqualTo(strike);
		assertThat(result.getBall())
			.isEqualTo(ball);
	}
}