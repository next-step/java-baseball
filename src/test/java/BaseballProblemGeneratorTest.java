import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballProblemGeneratorTest {

	private BaseballProblemGenerator generator;

	@BeforeEach
	void beforeEach() {
		generator = new BaseballProblemGenerator();
	}

	@DisplayName("문제를 생성하면, 임의의 숫자 3개가 반환된다.")
	@Test
	void test1() {
		LinkedHashSet<Integer> result = generator.generate();
		assertEquals(3, result.size());
	}

	@DisplayName("각 숫자는 중복되지 않는다")
	@Test
	void test2() {
		LinkedHashSet<Integer> result = generator.generate();
		assertEquals(3, result.size());
	}

	@DisplayName("초기화 시킬 수 있다")
	@Test
	void test3() {
		LinkedHashSet<Integer> result = generator.generate();
		generator.resetProblem();
	}
}
