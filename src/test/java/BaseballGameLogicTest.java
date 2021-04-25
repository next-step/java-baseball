import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameLogicTest {
	String number;

	@BeforeEach
	void setUp() {
		BaseballGameLogic baseballGameLogic = new BaseballGameLogic();
		baseballGameLogic.makeNumber();
		number = baseballGameLogic.getNumber();
	}

	@Test
	@DisplayName("세자리인지 확인")
	public void is_three_digit() {
		assertThat(number.length() == 3).isTrue();
	}

	@Test
	@DisplayName("숫자인지 확인")
	public void is_number() {
		assertThat(Integer.parseInt(number)).isInstanceOf(Integer.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("각 자리 수가 서로 다른지 확인")
	public void is_not_duplicated(int index) {
		assertThat(number.charAt(index) != number.charAt((index + 1) % 3)).isTrue();
	}
}
