package baseballnumber;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberBoardTest {

	@Test
	@DisplayName("Strike 와 ball 의 합이 3 이하여야 한다")
	void sumOfStrikeAndBallShouldBeUnder3() {
		// given

		// when

		// then
		assertThatIllegalArgumentException().isThrownBy(() -> new BaseballNumberBoard(3, 1));
	}

	@Test
	@DisplayName("Strike 가 3개이면 isContinue 가 false 를 리턴하여야 한다")
	void isFinishShouldBeTrueOnTaking3Strike() {
		// given
		BaseballNumberBoard baseballNumberBoard = new BaseballNumberBoard(3, 0);

		// when
		boolean result = baseballNumberBoard.isContinue();

		// then
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("Strike 가 3개가 아니면, isContinue 가 true 를 리턴하여야 한다")
	void isFinishShouldBeFalseOnTaking2Strike() {
		// given
		BaseballNumberBoard baseballNumberBoard = new BaseballNumberBoard(2, 1);

		// when
		boolean result = baseballNumberBoard.isContinue();

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("Strike 나 ball 이 1 이상이면, isNothing 은 false 를 리턴하여야 한다")
	void isNothingShouldBeFalseIfStrikeOrBallIsGreaterThan1() {
		// given
		BaseballNumberBoard baseballNumberBoard = new BaseballNumberBoard(0, 1);

		// when
		boolean result = baseballNumberBoard.isNothing();

		// then
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("Strike 와 ball 이 0 이면, isNothing 은 true 를 리턴하여야 한다")
	void isNothingShouldBeTrueIfStrikeOrBallIs0() {
		// given
		BaseballNumberBoard baseballNumberBoard = new BaseballNumberBoard(0, 0);

		// when
		boolean result = baseballNumberBoard.isNothing();

		// then
		assertThat(result).isTrue();
	}
}
