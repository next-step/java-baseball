import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameLogicTest {
	String number;
	BaseballGameLogic baseballGameLogic;

	@BeforeEach
	void setUp() {
		baseballGameLogic = new BaseballGameLogic();
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

	@Test
	@DisplayName("스트라이크 / 볼 / 낫싱 로직 정상 여부 확인")
	public void is_logic_ok() {
		String targetInput;

		targetInput = "0" + number.substring(1);
		assertThat(baseballGameLogic.getScore(targetInput).equals("2 스트라이크 ")).isTrue();
		targetInput = number;
		assertThat(baseballGameLogic.getScore(targetInput).equals("3 스트라이크 ")).isTrue();
		targetInput = number.substring(2) + number.substring(0, 2);
		assertThat(baseballGameLogic.getScore(targetInput).equals("3 볼")).isTrue();
		targetInput = number.substring(0, 1) + number.substring(2, 3) + number.substring(1, 2);
		assertThat(baseballGameLogic.getScore(targetInput).equals("1 스트라이크 2 볼")).isTrue();
		targetInput = "000";
		assertThat(baseballGameLogic.getScore(targetInput).equals("낫싱")).isTrue();
	}
}
