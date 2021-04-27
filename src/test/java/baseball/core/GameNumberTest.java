package baseball.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class GameNumberTest {
	private static Round round;
	private static GameNumber gameNumber;

	@BeforeAll
	public static void beforeAll() {
		round = new Round(123);
		gameNumber = new GameNumber();
	}

	@DisplayName("원하는 자릿수 랜덤생성 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	public void initRandomDigits(int index) {
		for (int i = 0; i < 1000; i++) {
			int randamValue = gameNumber.getRandom(index);

			assertEquals(index, round.numberLength(randamValue));
		}
	}

	@RepeatedTest(1000)
	@DisplayName("중복되지않은 세자리 확인")
	public void initRandomDigits() {
		int randamValue = gameNumber.getRandom(3);
		int num1 = round.getPlaceValue(randamValue, 0);
		int num2 =round.getPlaceValue(randamValue, 1);
		int num3 =round.getPlaceValue(randamValue, 2);

		assertThat(num1).isNotEqualTo(num2).isNotEqualTo(num3);
		assertThat(num2).isNotEqualTo(num1).isNotEqualTo(num3);
		assertThat(num3).isNotEqualTo(num1).isNotEqualTo(num2);
	}


	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 10, 100})
	@DisplayName("의도하지 않은 파라미터")
	public void getRandomIllegalArgument(int digits) {
		assertThatIllegalArgumentException().isThrownBy(()->gameNumber.getRandom(digits));
	}

}
