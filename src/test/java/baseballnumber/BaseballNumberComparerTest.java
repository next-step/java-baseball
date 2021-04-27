package baseballnumber;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballNumberComparerTest {

	@Test
	@DisplayName("입력된 두 값이 123 ~ 987 사이가 아니라면 에러를 반환한다")
	void inputNumbersShouldBeValid() {
		// given

		// when

		// then
		assertThatIllegalArgumentException().isThrownBy(() -> new BaseballNumberComparer(122, 123));
		assertThatIllegalArgumentException().isThrownBy(() -> new BaseballNumberComparer(988, 987));
	}

	@ParameterizedTest
	@CsvSource({"123,0", "912,1", "982,2"})
	@DisplayName("입력한 두 값이 BaseballNumberDigit 의 list 로 변환되어, compare 를 수행할 수 있어야 한다. 0,1,2 strike")
	void careStrikeOnComparingToListsOfDigit(int input, int strikeExpected) {
		// given
		BaseballNumberComparer comparer = new BaseballNumberComparer(987, input);

		// when
		BaseballNumberBoard result = comparer.compare();

		// then
		assertThat(result).isEqualTo(new BaseballNumberBoard(strikeExpected, 0));
	}

	@ParameterizedTest
	@CsvSource({"123,0", "812,1", "298,2"})
	@DisplayName("입력한 두 값이 BaseballNumberDigit 의 list 로 변환되어, compare 를 수행할 수 있어야 한다. 0,1,2 ball")
	void careBallOnComparingToListsOfDigit(int input, int ballExpected) {
		// given
		BaseballNumberComparer comparer = new BaseballNumberComparer(987, input);

		// when
		BaseballNumberBoard result = comparer.compare();

		// then
		assertThat(result).isEqualTo(new BaseballNumberBoard(0, ballExpected));
	}
}
