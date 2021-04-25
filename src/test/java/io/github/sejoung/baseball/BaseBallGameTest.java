package io.github.sejoung.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.sejoung.baseball.constants.GameMessage;
import io.github.sejoung.baseball.constants.PlayMessage;
import io.github.sejoung.baseball.constants.ValidatorMessage;

class BaseBallGameTest {

	private final static String NEW_LINE = System.lineSeparator();

	@DisplayName("게임 초기화시 완료 상태가 아니다")
	@Test
	void initialized_isCompletedTest() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		assertThat(game.isCompleted()).isFalse();
	}

	@DisplayName("게임 실행시 숫자를 입력해주세요 메시지 출력")
	@Test
	void print_inputMessage() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		String actual = game.flushOutput();

		assertThat(actual).isEqualTo(GameMessage.INPUT);
	}

	@DisplayName("플레이어가 입력한 값은 3자리 이다.")
	@Test
	void playerInputNumberSizeValidation() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		game.flushOutput();
		game.processInput("12");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(ValidatorMessage.LENGTH + NEW_LINE + GameMessage.INPUT);
		game.processInput("1234");
		assertThat(actual).isEqualTo(ValidatorMessage.LENGTH + NEW_LINE + GameMessage.INPUT);
	}

	@DisplayName("플레이어가 입력한 값은 숫자이다.")
	@Test
	void playerInputNumberValidation() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		game.flushOutput();
		game.processInput("한글");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(ValidatorMessage.NUMBER + NEW_LINE + GameMessage.INPUT);
	}

	@DisplayName("플레이어가 입력한 숫자가 컴퓨터 숫자를 모두 맞춤 메시지 확인")
	@Test
	void playerInputNumberThreeStrikeMessageTest() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		game.flushOutput();
		game.processInput("123");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(
			PlayMessage.getStrike(3) + NEW_LINE + GameMessage.SUCCESS + NEW_LINE + GameMessage.RESTART);
	}

	@DisplayName("게임 재시작 확인")
	@Test
	void gameRestartTest() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		game.flushOutput();
		game.processInput("123");
		game.flushOutput();
		game.processInput("1");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(GameMessage.INPUT);
	}

}
