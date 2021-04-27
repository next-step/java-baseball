package baseball;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContainsCheckerTest {

	private int[] numbers;
	
	@BeforeEach
    void setUp() {
        numbers = new int[] {5, 4, 1};
    }
	
	@ParameterizedTest
    @DisplayName("배열 들어있는 값 확인")
    @ValueSource(ints = {1, 4, 2})
    public void testIsContains(int testValue) {
        assertThat(Arrays.asList(numbers).contains(testValue)).isTrue();
    }

}
