import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumberGeneratorTest {

	private Set<Integer> numbers;

	BaseBallNumberGenerator baseBallNumberGenerator = new BaseBallNumberGenerator(3);

	@DisplayName("컴퓨터 난수 성생 테스트")
	@Test
	public void makeComputerNumbers() {
		String testData = baseBallNumberGenerator.makeComputerNumbers(9, null);
		assertThat(testData).hasSize(3);
	}

	/*
	 *  입력 값에 따라 결과값이 다른 경우에 대한 테스트도 가능하도록 구현한다
	 */
	@DisplayName("입력된 숫자의 리스트화 테스트")
	@Test
	public void makeNumberListTest() {

		List<String> compareList = new ArrayList<>();
		compareList.add("3");
		compareList.add("2");
		compareList.add("4");

		List<String> testList = baseBallNumberGenerator.makeNumberList("324");
		assertThat(testList).isEqualTo(compareList);

		// 다른 값 테스트
		testList = null;
		testList = baseBallNumberGenerator.makeNumberList("453");
		assertThat(testList).isEqualTo(compareList);

	}

	@DisplayName("리스트 길이 테스트")
	@Test
	public void checkListSizeTest() {
		List<String> compareList = new ArrayList<>();
		compareList.add("3");
		compareList.add("2");
		compareList.add("4");

		assertTrue(baseBallNumberGenerator.checkListSize(compareList));
	}
}
