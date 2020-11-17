package kr.aterilio.nextstep.techcamp.baseball;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

	@RepeatedTest(30)
	public void GameCreateSuccessTest() {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.create();
		assertThat(baseballGame.isCreateSuccess()).isTrue();
		baseballGame.printBoard();
	}
}
