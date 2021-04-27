package nextstep.kht2199.precourse;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FBGameTest {

	FBGame game = new FBGame();

	@ParameterizedTest
	@MethodSource("ballStrikeCountMessageSource")
	@DisplayName("일치하는 숫자와 일치하지 않는 갯수를 입력받아 출력")
	void ballStrikeCountMessage(int ball, int strike, String expectedMessaged) {
		FootballMatchResult matchResult = new FootballMatchResult(ball, strike, false);
		assertThat(game.ballStrikeCountMessage(matchResult))
			.isEqualTo(expectedMessaged);
	}

	static Stream<Arguments> ballStrikeCountMessageSource() {
		return Stream.of(
			Arguments.of(0, 0, "낫싱"),
			Arguments.of(0, 1, "1 스트라이크"),
			Arguments.of(1, 0, "1 볼"),
			Arguments.of(1, 1, "1 스트라이크 1 볼")
		);
	}
}