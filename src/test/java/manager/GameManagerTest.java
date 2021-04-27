package manager;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameManagerTest {

	private GameManager gameManager = new GameManager();

	@ParameterizedTest
	@DisplayName("사용자 입력 검증 ")
	@CsvSource(value = {"123:true", "aaa:false", "a12:false", "1234:false"}, delimiter = ':')
	public void isValidNumber(String input, boolean expected) {
		assertThat(gameManager.validateInput(input)).isEqualTo(expected);
	}

	@Test
	@DisplayName("String to List<Integer> 테스트")
	public void convertTypeTest() {
		assertThat(gameManager.convertInputType("123")).isEqualTo(Arrays.asList(1, 2, 3));
	}
}
