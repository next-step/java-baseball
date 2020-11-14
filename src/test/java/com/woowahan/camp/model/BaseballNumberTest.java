package com.woowahan.camp.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

	@DisplayName("of 메서드로 BaseballNumber 객체를 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "197", "324"})
	void ofTest(String value) {
		//Given
		//When
		BaseballNumber result = BaseballNumber.of(value);

		//Then
		assertThat(result).isInstanceOf(BaseballNumber.class);
	}

	@DisplayName("getRandomBaseballNumber 메서드로 BaseballNumber 객체를 생성할 수 있다.")
	@RepeatedTest(100)
	void getRandomBaseballNumber() {
		//Given
		//When
		BaseballNumber result = BaseballNumber.getRandomBaseballNumber();

		//Then
		assertThat(result).isInstanceOf(BaseballNumber.class);
	}

	@DisplayName("checkStrikeAndBall 메서드는 다른 BaseballNumber객체를 받아 비교하여 GameResult객체를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "197", "324"})
	void checkStrikeAndBallReturnGameResult(String value) {
		//Given
		BaseballNumber computerNumber = BaseballNumber.getRandomBaseballNumber();
		BaseballNumber userNumber = BaseballNumber.of(value);

		//When
		GameResult result = computerNumber.checkStrikeAndBall(userNumber);

		//Then
		assertThat(result).isInstanceOf(GameResult.class);
	}

	@DisplayName("checkStrikeAndBall 메서드는 다른 BaseballNumber객체를 받아 비교하여 정확한 GameResult를 통해 strike와 ball을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"123:0:1", "374:1:1", "345:3:0", "678:0:0"}, delimiter = ':')
	void checkStrikeAndBallReturnExactly(String value, int expectStrike, int expectBall) {
		//Given
		BaseballNumber computerNumber = BaseballNumber.of("345");
		BaseballNumber userNumber = BaseballNumber.of(value);

		//When
		GameResult result = computerNumber.checkStrikeAndBall(userNumber);

		//Then
		assertThat(result.getStrike()).isEqualTo(expectStrike);
		assertThat(result.getBall()).isEqualTo(expectBall);
	}

	@DisplayName("randomGenerator메서드는 랜덤한 각기 다른 3자리의 수를 문자열로 반환한다.")
	@RepeatedTest(100)
	void randomGenerator() {
		//Given
		//When
		String result = BaseballNumber.randomGenerator();

		//Then
		assertThat(result.length()).isEqualTo(3);
		assertThat(countMatch(result, Character.toString(result.charAt(0)))).isEqualTo(1);
		assertThat(countMatch(result, Character.toString(result.charAt(1)))).isEqualTo(1);
		assertThat(countMatch(result, Character.toString(result.charAt(2)))).isEqualTo(1);
	}

	private int countMatch(String s, String match) {
		return s.length() - s.replaceAll(match, "").length();
	}

	@DisplayName("getStrikeCnt 메서드는 다른 BaseballNumber객체를 받아 비교하여 정확한 strike 수를 int로 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"123:0", "374:1", "345:3", "678:0"}, delimiter = ':')
	void getStrikeCnt(String value, int expectStrike) {
		//Given
		BaseballNumber computerNumber = BaseballNumber.of("345");
		BaseballNumber userNumber = BaseballNumber.of(value);

		//When
		int result = computerNumber.getStrikeCnt(userNumber);

		//Then
		assertThat(result).isEqualTo(expectStrike);
	}

	@DisplayName("getBallCnt 메서드는 다른 BaseballNumber객체를 받아 비교하여 정확한 strike 수를 int로 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"123:1", "374:1", "345:0", "678:0"}, delimiter = ':')
	void getBallCnt(String value, int expectBall) {
		//Given
		BaseballNumber computerNumber = BaseballNumber.of("345");
		BaseballNumber userNumber = BaseballNumber.of(value);

		//When
		int result = computerNumber.getBallCnt(userNumber);

		//Then
		assertThat(result).isEqualTo(expectBall);
	}

	@DisplayName("getInputValue 메서드는 BaseballNumber객체를 생성할때 입력받은 값을 다시 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "197", "324"})
	void getInputValue(String value) {
		//Given
		BaseballNumber number = BaseballNumber.of(value);

		//When
		String result = number.getInputValue();

		//Then
		assertThat(result).isEqualTo(value);
	}
}