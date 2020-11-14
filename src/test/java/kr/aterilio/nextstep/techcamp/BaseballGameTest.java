package kr.aterilio.nextstep.techcamp;

import kr.aterilio.nextstep.techcamp.baseball.Baseball;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

	@RepeatedTest(30)
	public void GameCreateSuccessTest() {
		Baseball baseball = new Baseball();
		baseball.printBoard();
		assertThat(baseball.isCreateSuccess()).isTrue();
	}
}
