package edu.nextstep.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import edu.nextstep.util.NumberUtil;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseballGameTest {
	BaseballGame game;
	BaseballGamer computer;
	BaseballScore score;

	@BeforeAll
	public void beforeAll() {
		game = new BaseballGame();
		game.resetComputer();
		computer = game.getComputer();
	}

	@ParameterizedTest(name = "#{index} : 컴퓨터숫자 : [{0}], 플레이어숫자 : [{1}]")
	@DisplayName("playToEnd : 끝까지 게임을 진행한 상황에 맞는 Score를 리턴해야 함")
	@MethodSource("getComputerNumberAndRandomPlayerNumber")
	void playToEnd_ShouldReturnScoreCorrectlyToEndOfGame(String computerNumber, String playerNumber) {
		// given
		game.resetScore();
		BaseballGamer player = new BaseballGamer(playerNumber);
		game.setPlayer(player);

		// when
		score = game.playToEnd();

		// then
		assertAll(
			() -> assertTrue(score.getStrike() + score.getBall() >= 0),
			() -> assertTrue(score.getStrike() + score.getBall() <= 3)
		);
	}

	public Stream<Arguments> getComputerNumberAndRandomPlayerNumber() {
		List<Arguments> numberList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numberList.add(Arguments.of(computer.getSelectedNumber(), NumberUtil.generateNonDuplicatedNumber(3)));
		}
		return numberList.stream();
	}
}