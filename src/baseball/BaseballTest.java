package baseball;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.util.GameStatus;


class BaseballTest {
	
	@BeforeEach
    void setUp() {
        numbers = new int[] {1, 2, 3};
    }
	
	private int[] numbers;

	@ParameterizedTest
    @DisplayName("배열 들어있는 값 확인")
    @ValueSource(ints = {1, 2, 3})
    public void testGetNumber(int testValue) {
        assertThat(Arrays.asList(numbers).contains(testValue)).isTrue();
    }
	
	@Test
	@DisplayName("배열 크기 확인")
	public void testGetBaseballSize() {
		assertThat(numbers.length == GameStatus.BALL_SIZE).isTrue();
	}

}
