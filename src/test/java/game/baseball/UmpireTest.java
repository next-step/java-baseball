package game.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UmpireTest {

	private Hitter hitter;
	private Pitcher pitcher;
	private Umpire umpire;

	@BeforeEach
	void setUp() {
		hitter = new Hitter();
		pitcher = new Pitcher();
		umpire = new Umpire();

		Set<Integer> hittingNumbers = new HashSet<>();
		hittingNumbers.add(3);
		hittingNumbers.add(7);
		hittingNumbers.add(9);

		hitter.setHittingNumbers(hittingNumbers);
	}

	@ParameterizedTest
	@DisplayName("1 스트라이크 1 볼 테스트")
	@ValueSource(strings = {"173"})
	public void isRight_Strike1AndBall1(String pitchNumbers) {
		pitcher.setPitch(pitchNumbers);
		pitcher.splitPitches();

		umpire.setHitter(hitter);
		umpire.setPitcher(pitcher);

		umpire.judge();

		assertThat(umpire.getBalls()).isEqualTo(1);
		assertThat(umpire.getStrikes()).isEqualTo(1);
	}



	@ParameterizedTest
	@DisplayName("1 스트라이크 2 볼 테스트")
	@ValueSource(strings = {"973"})
	public void isRight_Strike2AndBall1(String pitchNumbers) {
		pitcher.setPitch(pitchNumbers);
		pitcher.splitPitches();

		umpire.setHitter(hitter);
		umpire.setPitcher(pitcher);

		umpire.judge();

		assertThat(umpire.getBalls()).isEqualTo(2);
		assertThat(umpire.getStrikes()).isEqualTo(1);
	}

	@ParameterizedTest
	@DisplayName("3 스트라이크")
	@ValueSource(strings = {"379"})
	public void isRight_3Strikes(String pitchNumbers) {
		pitcher.setPitch(pitchNumbers);
		pitcher.splitPitches();

		umpire.setHitter(hitter);
		umpire.setPitcher(pitcher);

		umpire.judge();

		assertThat(umpire.getBalls()).isEqualTo(0);
		assertThat(umpire.getStrikes()).isEqualTo(3);
	}
}