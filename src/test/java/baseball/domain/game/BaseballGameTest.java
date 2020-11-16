package baseball.domain.game;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Computer;
import baseball.domain.Player;

public class BaseballGameTest {

	@Test
	@DisplayName("Player, Computer : strike, ball 계산 확인")
	public void calcBaseball() {
		Computer computer = new Computer();
		List<Integer> input = new ArrayList<>(Arrays.asList(4, 3, 2));
		computer.setBaseball(input);
		Player player = new Player();
		player.inputBaseBall("234");
		BaseballGame baseballGame = new BaseballGame();

		baseballGame.calcBaseball(computer, player);
		assertThat(player.getStrikeCount()).isEqualTo(1);
		assertThat(player.getBallCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("Player, Computer : 계산 후 결과 텍스트 확인")
	public void scoreBaseball() {
		Player player = new Player();
		BaseballGame baseballGame = new BaseballGame();
		player.setStrikeCount(2);
		player.setBallCount(1);

		String result = "2 스트라이크 1볼";
		String scoreResult = baseballGame.scoreBaseball(player);

		assertThat(scoreResult).isEqualTo(result);
	}

}
