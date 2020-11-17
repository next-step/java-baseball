package kr.aterilio.nextstep.techcamp.baseball;

import kr.aterilio.nextstep.techcamp.baseball.ui.InputView;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

	@DisplayName("게임 생성 테스트")
	@RepeatedTest(30)
	public void GameCreateSuccessTest() {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.create();
		assertThat(baseballGame.isCreateSuccess()).isTrue();
		baseballGame.printBoard();
	}

	@DisplayName("게임 판정 테스트")
	@ParameterizedTest
	@CsvSource({"834,123,0,1", "264,245,1,1", "645,349,1,0", "867,421,0,0"})
	public void JudgeTest(int computer, int user, int strike, int ball) {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.create(InputView.splitInput(computer));

		BaseballResult baseballResult = baseballGame.judge(InputView.splitInput(user));

		assertThat(baseballResult.getCountStrike()).isEqualTo(strike);
		assertThat(baseballResult.getCountBall()).isEqualTo(ball);
	}
}
