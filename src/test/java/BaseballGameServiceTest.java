import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameServiceTest {
	BaseballGameService baseballGameService = new BaseballGameService();

	@DisplayName("1-9사이의 숫자를 중복없이 3개 뽑는다")
	@Test
	public void peek3RandomDistinctNumbersTest() {
		int[] peek = baseballGameService.peek3RandomDistinctNumbers();

		// 중복되는 숫자가 없어야 한다.
		assertEquals(3, Arrays.stream(peek)
			.distinct()
			.count());

		// 1 이상 9 이하의 숫자로 구성되어야 한다.
		assertEquals(3, Arrays.stream(peek)
			.filter(num -> num >= 1 && num <= 9)
			.count());
	}

}
