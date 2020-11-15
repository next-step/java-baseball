import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("점수 클래스테스트")
class ScoreTest {

	private Score score = new Score();

	// @Test
	// @DisplayName("스트라이크 테스트")
	// void isAllStrike() {
	// 	score.addStrike();
	// 	score.addStrike();
	// 	score.addStrike();
	//
	// 	assertThat(score.isAllStrike()).isTrue();
	// }

	@Test
	@DisplayName("점수 결과 출력 테스트")
	void getScoreString() {
		assertThat(score.calculateScore()).isEqualTo("포볼");
	}
}