package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

	@DisplayName("게임결과 - 3스트라이크 0볼")
	@Test
	void getGameResult_three_strike() {
		BaseBallGame baseBallGame = new BaseBallGame();
		Computer computer = new Computer();
		computer.setNumber(new Number(123));
		Player player = new Player();
		player.setNumber(new Number(123));
		baseBallGame.getGameResult(computer, player);

		GameStatus gameStatus = new GameStatus();
		gameStatus.setStrike(3);
		gameStatus.setBall(0);
		assertEquals(baseBallGame.getGameStatus(), gameStatus);
	}

	@DisplayName("게임결과 - 0스트라이크 0볼")
	@Test
	void getGameResult_zero_strike_zero_ball() {
		BaseBallGame baseBallGame = new BaseBallGame();
		Computer computer = new Computer();
		computer.setNumber(new Number(123));
		Player player = new Player();
		player.setNumber(new Number(456));
		baseBallGame.getGameResult(computer, player);

		GameStatus gameStatus = new GameStatus();
		gameStatus.setStrike(0);
		gameStatus.setBall(0);
		assertEquals(baseBallGame.getGameStatus(), gameStatus);
	}

	@DisplayName("게임결과 - 0스트라이크 3볼")
	@Test
	void getGameResult_three_strike2() {
		BaseBallGame baseBallGame = new BaseBallGame();
		Computer computer = new Computer();
		computer.setNumber(new Number(123));
		Player player = new Player();
		player.setNumber(new Number(231));
		baseBallGame.getGameResult(computer, player);

		GameStatus gameStatus = new GameStatus();
		gameStatus.setStrike(0);
		gameStatus.setBall(3);
		assertEquals(baseBallGame.getGameStatus(), gameStatus);
	}
}
