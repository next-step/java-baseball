package ttuop.nextstep.baseball;

import static org.assertj.core.api.Assertions.*;
import static ttuop.nextstep.baseball.Constants.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeCallResolverTest {

	@ParameterizedTest
	@CsvSource({"123,abc", "123,111", "123,"})
	@DisplayName("유효하지 않은 숫자 메시지 테스트")
	void testGetInvalidNumberMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo(INVALID_NUMBER_MESSAGE);
	}

	@ParameterizedTest
	@CsvSource({"123,123", "456,456", "789,789"})
	@DisplayName("3 스트라이크 메시지 테스트")
	void testGetThreeStrikeMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo(THREE_STRIKE_MESSAGE);
	}

	@ParameterizedTest
	@CsvSource({"123,456", "456,789", "789,123"})
	@DisplayName("낫싱 메시지 테스트")
	void testGetNothingMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo(NOTHING_MESSAGE);
	}

	@ParameterizedTest
	@CsvSource({"123,156", "456,759", "789,129"})
	@DisplayName("1 스트라이크 메시지 테스트")
	void testGetOneStrikeMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo("1 " + STRIKE);
	}

	@ParameterizedTest
	@CsvSource({"123,126", "456,756", "789,729"})
	@DisplayName("2 스트라이크 메시지 테스트")
	void testGetTwoStrikeMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo("2 " + STRIKE);
	}

	@ParameterizedTest
	@CsvSource({"123,416", "456,784", "789,923"})
	@DisplayName("1 볼 메시지 테스트")
	void testGetOneBallMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo("1 " + BALL);
	}

	@ParameterizedTest
	@CsvSource({"123,412", "456,684", "789,973"})
	@DisplayName("2 볼 메시지 테스트")
	void testGetTwoBallMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo("2 " + BALL);
	}

	@ParameterizedTest
	@CsvSource({"123,134", "456,467", "789,791"})
	@DisplayName("1 스트라이크 1 볼 메시지 테스트")
	void testGetOneStrikeOneBallMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo("1 " + STRIKE + " 1 " + BALL);
	}

	@ParameterizedTest
	@CsvSource({"123,132", "456,546", "789,987"})
	@DisplayName("1 스트라이크 2 볼 메시지 테스트")
	void testGetOneStrikeTwoBallMessage(String answer, String input) {
		Referee referee = new Referee(answer);
		String message = RefereeCallResolver.getMessage(referee.findStrike(input), referee.findBall(input));

		assertThat(message).isEqualTo("1 " + STRIKE + " 2 " + BALL);
	}

}
