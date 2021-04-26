package baseball.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballScoreTest {

	@DisplayName("같은 수가 같은 자리인 경우 스트라이크로 판단한다.")
	@ParameterizedTest
	@CsvSource(value = {"197:123", "357:247", "152:359"}, delimiter = ':')
	void strikeTest(String pitcherNum, String hitterNum) {
		BaseballScore baseballScore = new BaseballScore(pitcherNum, hitterNum);
		assertThat(baseballScore.getScoreStr()).isEqualTo("1스트라이크 ");
	}

	@DisplayName("같은 수가 다른 자리인 경우 볼로 판단한다.")
	@ParameterizedTest
	@CsvSource(value = {"197:213", "357:274", "152:395"}, delimiter = ':')
	void ballTest(String pitcherNum, String hitterNum) {
		BaseballScore baseballScore = new BaseballScore(pitcherNum, hitterNum);
		assertThat(baseballScore.getScoreStr()).isEqualTo("1볼");
	}

	@DisplayName("같은 수가 전혀 없으면 낫싱이 반환된다.")
	@ParameterizedTest
	@CsvSource(value = {"197:423", "357:248", "152:369"}, delimiter = ':')
	void nothingTest(String pitcherNum, String hitterNum) {
		BaseballScore baseballScore = new BaseballScore(pitcherNum, hitterNum);
		assertThat(baseballScore.getScoreStr()).isEqualTo("낫싱");
	}

	@DisplayName("같은 수가 같은 자리에 있고, 같은 수가 다른 자리에 있는 경우, 스트라이크, 볼이 같이 반환된다.")
	@ParameterizedTest
	@CsvSource(value = {"197:173", "457:247", "952:359"}, delimiter = ':')
	void strikeBallTest(String pitcherNum, String hitterNum) {
		BaseballScore baseballScore = new BaseballScore(pitcherNum, hitterNum);
		assertThat(baseballScore.getScoreStr()).isEqualTo("1스트라이크 1볼");
	}
}