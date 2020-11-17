package baseball.players.referee;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.players.opponent.Computer;
import baseball.players.opponent.Opponent;
import baseball.players.player.TestPlayer;
import baseball.stadium.report.Report;

class RefereeTest {

	@Test
	@DisplayName("같은자리에 있으면 스트라이크")
	void toDecideToStrike() {
		TestPlayer player = new TestPlayer("123");

		Opponent opponent = new Computer(Arrays.asList(3, 2, 4));
		DefaultReferee referee = new DefaultReferee(opponent);
		Report report = referee.decide(player);

		assertThat(report.isStrikeOut()).isFalse();
		assertThat(report.isFourBall()).isFalse();
		assertThat(report.getStrike()).isEqualTo(1);
		assertThat(report.getBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("다른 자리에 있으면 볼")
	public void toDecideToBall() {
		TestPlayer player = new TestPlayer("123");

		Opponent opponent = new Computer(Arrays.asList(2, 3, 1));
		DefaultReferee referee = new DefaultReferee(opponent);
		Report report = referee.decide(player);

		assertThat(report.isStrikeOut()).isFalse();
		assertThat(report.isFourBall()).isFalse();
		assertThat(report.getBall()).isEqualTo(3);
		assertThat(report.getStrike()).isEqualTo(0);
	}

	@Test
	@DisplayName("동일한 숫자 없으면 포볼")
	public void toDecideToFourBall() {
		TestPlayer player = new TestPlayer("598");

		Opponent opponent = new Computer(Arrays.asList(2, 3, 1));
		DefaultReferee referee = new DefaultReferee(opponent);
		Report report = referee.decide(player);

		assertThat(report.isStrikeOut()).isFalse();
		assertThat(report.isFourBall()).isTrue();
		assertThat(report.getBall()).isEqualTo(0);
		assertThat(report.getStrike()).isEqualTo(0);
	}

	@Test
	@DisplayName("3자리가 모두 스트라이크 게임 종료")
	public void toDecideTo3Strike() {
		TestPlayer player = new TestPlayer("123");

		Opponent opponent = new Computer(Arrays.asList(1, 2, 3));
		DefaultReferee referee = new DefaultReferee(opponent);
		Report report = referee.decide(player);

		assertThat(report.isStrikeOut()).isTrue();
		assertThat(report.isFourBall()).isFalse();
		assertThat(report.getBall()).isEqualTo(0);
		assertThat(report.getStrike()).isEqualTo(3);
	}

	@Test
	void resetOpponent() {
	}
}
