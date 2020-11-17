package baseball.stadium;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.display.DefaultDisplay;
import baseball.display.Display;
import baseball.opponent.Computer;
import baseball.opponent.Opponent;
import baseball.player.Player;
import baseball.player.TestPlayer;
import baseball.referee.DefaultReferee;
import baseball.report.Report;

class StadiumTest {

	@Test
	@DisplayName("스트라이크 아웃")
	void toCheckStrikeOut() {
		String strRequestNumbers = "123";
		List<Integer> hiddenNumbers = Arrays.asList(1, 2, 3);

		Opponent opponent = new Computer(hiddenNumbers);
		Player player = new TestPlayer(strRequestNumbers);
		DefaultReferee referee = new DefaultReferee(opponent);
		Display display = new DefaultDisplay();

		Stadium stadium = new Stadium(referee, display);
		Report report = stadium.inning(player);

		assertThat(report.isStrikeOut()).isTrue();
	}

	@Test
	@DisplayName("경기 재시작")
	void toCheckRestartGame() {
		String strRequestNumbers = "123";
		List<Integer> hiddenNumbers = Arrays.asList(1, 2, 3);

		Opponent opponent = new Computer(hiddenNumbers);
		TestPlayer player = new TestPlayer(strRequestNumbers);
		player.setContinue("1");
		DefaultReferee referee = new DefaultReferee(opponent);
		Display display = new DefaultDisplay();

		Stadium stadium = new Stadium(referee, display);
		boolean isRestart = stadium.restart(player);

		assertThat(isRestart).isTrue();
	}

	@Test
	@DisplayName("경기 연장 안함")
	void toCheckDontRestart() {
		String strRequestNumbers = "123";
		List<Integer> hiddenNumbers = Arrays.asList(1, 2, 3);

		Opponent opponent = new Computer(hiddenNumbers);
		TestPlayer player = new TestPlayer(strRequestNumbers);
		player.setContinue("2");
		DefaultReferee referee = new DefaultReferee(opponent);
		Display display = new DefaultDisplay();

		Stadium stadium = new Stadium(referee, display);
		boolean isRestart = stadium.restart(player);

		assertThat(isRestart).isFalse();
	}
}
