package io.github.sejoung.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.sejoung.baseball.constants.GameMessage;
import io.github.sejoung.baseball.constants.PlayMessage;
import io.github.sejoung.baseball.constants.ValidatorMessage;

class BaseBallGameTest extends BaseBallGameParameterized {

	private final static String NEW_LINE = System.lineSeparator();

	@DisplayName("게임 초기화시 완료 상태가 아니다")
	@Test
	void initialized_isCompletedTest() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(Arrays.asList(1, 2, 3)));
		assertThat(game.isCompleted()).isFalse();
	}

	@DisplayName("게임 실행시 숫자를 입력해주세요 메시지 출력")
	@Test
	void print_inputMessage() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(Arrays.asList(1, 2, 3)));
		String actual = game.flushOutput();

		assertThat(actual).isEqualTo(GameMessage.INPUT);
	}

	@DisplayName("플레이어가 입력한 값은 3자리 이다.")
	@Test
	void playerInputNumberSizeValidation() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(Arrays.asList(1, 2, 3)));
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
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(Arrays.asList(1, 2, 3)));
		game.flushOutput();
		game.processInput("한글");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(ValidatorMessage.NUMBER + NEW_LINE + GameMessage.INPUT);
	}

	@ParameterizedTest(name = "{index} 플레이어가 입력한 숫자가 컴퓨터 숫자를 모두 맞춤 메시지 확인 => numbers = {0}, input = {1}")
	@MethodSource("generateThreeStrikeArgumentsStream")
	void playerInputNumberThreeStrikeMessageTest(List<Integer> numbers, String input) {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(numbers));
		game.flushOutput();
		game.processInput(input);
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(
			PlayMessage.getStrike(3) + NEW_LINE + GameMessage.SUCCESS + NEW_LINE + GameMessage.RESTART);
	}

	@ParameterizedTest(name = "{index} 게임 재시작 확인 => numbers = {0}, input = {1}")
	@MethodSource("generateThreeStrikeArgumentsStream")
	void gameRestartTest(List<Integer> numbers, String input) {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(numbers));
		game.flushOutput();
		game.processInput(input);
		game.flushOutput();
		game.processInput("1");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(GameMessage.INPUT);
	}

	@ParameterizedTest(name = "{index} 게임 종료 확인 => numbers = {0}, input = {1}")
	@MethodSource("generateThreeStrikeArgumentsStream")
	void gameEndTest(List<Integer> numbers, String input) {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(numbers));
		game.flushOutput();
		game.processInput(input);
		game.flushOutput();
		game.processInput("2");
		assertThat(game.isCompleted()).isTrue();
	}

	@DisplayName("플레이어가 입력한 값이 틀리면 낫싱 메시지 출력")
	@Test
	void nothingMessageTest() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(Arrays.asList(1, 2, 3)));
		game.flushOutput();
		game.processInput("456");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(PlayMessage.NOTHING);
	}

	@ParameterizedTest(name = "{index} 볼 이면 볼 메시지를 출력한다. => numbers = {0}, input = {1}, ballCount = {2}")
	@MethodSource("generateBallArgumentsStream")
	void ballTest(List<Integer> numbers, String input, int ballCount) {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(numbers));
		game.flushOutput();
		game.processInput(input);
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(PlayMessage.getBall(ballCount));
	}

	@ParameterizedTest(name = "{index} 스트라이크이면 스트라이크 메시지를 출력한다. => numbers = {0}, input = {1}, ballCount = {2}")
	@MethodSource("generateStrikeArgumentsStream")
	void strikeTest(List<Integer> numbers, String input, int strikeCount) {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(numbers));
		game.flushOutput();
		game.processInput(input);
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo(PlayMessage.getStrike(strikeCount));
	}

}
