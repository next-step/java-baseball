package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import view.InputView;

class BaseBallGameResultTest {

	@ParameterizedTest
	@CsvSource(value = {"326:123:1", "326:321:2", "326:356:2", "326:378:1", "326:359:1"}, delimiter = ':')
	@DisplayName("클라이언트가 입력한 숫자와 정답숫자를 비교하여 몇 스크라이크 인지 확인해주는 기능")
	void strikeCountTest(String randomBallNumber, String userBallNumber, int strikeCount) {
		assertThat(createBaseBallGameResult(randomBallNumber, userBallNumber).getStrikeCount()).isEqualTo(strikeCount);
	}

	@ParameterizedTest
	@CsvSource(value = {"326:123:1", "326:321:0", "326:356:0", "326:362:2", "326:612:2"}, delimiter = ':')
	@DisplayName("클라이언트가 입력한 숫자와 정답숫자를 비교하여 몇 볼 인지 확인해주는 기능")
	void ballCountTest(String randomBallNumber, String userBallNumber, int ballCount) {
		assertThat(createBaseBallGameResult(randomBallNumber, userBallNumber).getBallCount()).isEqualTo(ballCount);
	}

	@ParameterizedTest
	@CsvSource(value = {"326:123:false", "326:789:true", "326:356:false", "326:321:false",
		"326:154:true"}, delimiter = ':')
	@DisplayName("클라이언트가 입력한 숫자와 정답숫자를 비교하여 몇 낫싱 인지 확인해주는 기능")
	void nothingCountTest(String randomBallNumber, String userBallNumber, boolean isNothing) {
		assertThat(createBaseBallGameResult(randomBallNumber, userBallNumber).isNothing()).isEqualTo(isNothing);
	}

	@ParameterizedTest
	@CsvSource(value = {"326:326:true", "326:327:false", "326:623:false", "567:567:true",
		"326:321:false"}, delimiter = ':')
	@DisplayName("클라이언트가 입력한 숫자와 정답숫자를 비교하여 정답 인지 확인해주는 기능")
	void homeRunCountTest(String randomBallNumber, String userBallNumber, boolean isAnswer) {
		assertThat(createBaseBallGameResult(randomBallNumber, userBallNumber).isAnswer()).isEqualTo(isAnswer);
	}

	private BaseBallGameResult createBaseBallGameResult(String randomBallNumber, String userBallNumber) {
		RandomBallNumbers randomBallNumbers = new RandomBallNumbers(InputView.stringToListConvert(randomBallNumber));
		UserBallNumbers userBallNumbers = new UserBallNumbers(InputView.stringToListConvert(userBallNumber));
		return new BaseBallGameResult(randomBallNumbers, userBallNumbers);
	}

}
