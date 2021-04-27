import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

	@Test
	@DisplayName(value = "1 strike 으로 판결되면 STRIKE의 value 는 1 이다.")
	void strikeOnlyOne() {
		Referee referee = new Referee(123, "175");
		Map<Result, Integer> result = referee.getScore();
		assertThat(result.get(Result.STRIKE)).isEqualTo(1);
	}

	@Test
	@DisplayName(value = "2 stirke 로 판결되면 STRIKE의 value 는 2 이다.")
	void twoStrike() {
		Referee referee = new Referee(125, "175");
		Map<Result, Integer> result = referee.getScore();
		assertThat(result.get(Result.STRIKE)).isEqualTo(2);
	}

	@Test
	@DisplayName(value = "1 strike 2 ball 인 경우 STRIKE 는 1, BALL은 2를 value로 갖는다")
	void oneStrikeTwoBall() {
		Referee referee = new Referee(259, "952");
		Map<Result, Integer> result = referee.getScore();
		assertThat(result.get(Result.STRIKE)).isEqualTo(1);
		assertThat(result.get(Result.BALL)).isEqualTo(2);
	}

	@Test
	@DisplayName(value = "득점이 없는 경우 size는 0이 된다.")
	void noScore() {
		Referee referee = new Referee(259, "138");
		Map<Result, Integer> result = referee.getScore();
		assertThat(result.size()).isEqualTo(0);
		assertThat(result.containsKey(Result.STRIKE)).isFalse();
		assertThat(result.containsKey(Result.BALL)).isFalse();
	}

	@Test
	@DisplayName(value = "3 strike 가 되면 finish 는 true 를 반환한다")
	void finish() {
		Referee referee = new Referee(369, "369");
		assertThat(referee.isFinish()).isTrue();
	}

}
