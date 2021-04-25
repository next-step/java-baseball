package baseball;

import baseball.player.Computer;
import baseball.player.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 2:04 AM
 */

class BaseballGameTest {
	private BaseballGame baseballGame;
	private Computer computer;
	private User user;

	@BeforeEach
	void setup() {
		baseballGame = new BaseballGame();
		computer = new Computer();
		user = new User();
	}

	@Test
	@DisplayName("컴퓨터와 유저의 볼이 같으면 게임이 승리하는지 확인")
	void shutdownGameIf3Strike() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		int[] computerBalls = computer.selectComputerBalls(3);
		StringBuilder sb = new StringBuilder();
		for (int computerBall : computerBalls) {
			sb.append(computerBall);
		}
		int[] userBalls = user.selectUserBalls(3, sb.toString());
		Method match = baseballGame.getClass().getDeclaredMethod("match", int[].class, int[].class);
		match.setAccessible(true);
		boolean isWin = (boolean)match.invoke(baseballGame, computerBalls, userBalls);
		assertThat(isWin).isTrue();
	}

	@DisplayName("각 스트라이크/볼 수에 맞는 메시지가 출력되는지 확인")
	@ParameterizedTest
	@CsvSource(value = {
		"1, 1, 1스트라이크 1볼",
		"1, 2, 1스트라이크 2볼",
		"1, 3, 1스트라이크 3볼",
		"2, 0, 2스트라이크",
		"0, 3, 3볼",
		"0, 0, 낫싱" })
	void validCreateResultMessage(int strike, int ball, String message)
		throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method createResultMessage = baseballGame.getClass().getDeclaredMethod("createResultMessage", int.class, int.class);
		createResultMessage.setAccessible(true);
		String resultMessage = (String)createResultMessage.invoke(baseballGame, strike, ball);
		assertThat(resultMessage.trim()).isEqualTo(message);
	}
}
