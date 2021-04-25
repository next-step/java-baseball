package number;

import static number.MatchResult.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersMatchResultTest {

	@Test
	@DisplayName("3 숫자가 위치, 값 모두 틀리면 NOT_MATCH 가 3개 나와야 한다.")
	public void nothingTest() {
		// given
		Numbers myNumbers = Numbers.of("123");
		Numbers yourNumbers = Numbers.of("456");

		// when
		NumbersMatchResult numbersMatchResult = myNumbers.match(yourNumbers);

		// then
		assertThat(numbersMatchResult.countOfResult(NOT_MATCH)).isEqualTo(3);
	}

	@Test
	@DisplayName("1개의 숫자가 위치와 값 모두 맞고, 2개의 숫자가 위치는 다르지만 값이 맞다면 STRIKE 1개 BALL 2개가 나와야 한다.")
	public void oneStrikeTwoBallTest() {
		// given
		Numbers myNumbers = Numbers.of("123");
		Numbers yourNumbers = Numbers.of("321");

		// when
		NumbersMatchResult numbersMatchResult = myNumbers.match(yourNumbers);

		// then
		assertThat(numbersMatchResult.countOfResult(STRIKE)).isEqualTo(1);
		assertThat(numbersMatchResult.countOfResult(BALL)).isEqualTo(2);
	}

	@Test
	@DisplayName("3 숫자 모두 값은 같지만 위치가 다르면 3 BALL 이 나와야 한다.")
	public void threeBallTest() {
		// given
		Numbers myNumbers = Numbers.of("123");
		Numbers yourNumbers = Numbers.of("312");

		// when
		NumbersMatchResult numbersMatchResult = myNumbers.match(yourNumbers);

		// then
		assertThat(numbersMatchResult.countOfResult(BALL)).isEqualTo(3);
	}

	@Test
	@DisplayName("3 숫자 모두 값도 같도 위치도 같다면 3 STRIKE 이 나와야 한다.")
	public void threeStrikeTest() {
		// given
		Numbers myNumbers = Numbers.of("123");
		Numbers yourNumbers = Numbers.of("123");

		// when
		NumbersMatchResult numbersMatchResult = myNumbers.match(yourNumbers);

		// then
		assertThat(numbersMatchResult.countOfResult(STRIKE)).isEqualTo(3);
	}

}
