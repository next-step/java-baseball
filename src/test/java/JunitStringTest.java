import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JunitStringTest {

	@Test
	public void testSum() {
		JunitString junitStudy = new JunitString();
		int result = junitStudy.sum(10, 10);
		assertEquals(20, result);
	}

	// String 요구사항1-1
	// "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	@Test
	public void testSplitIntArray1_1() {
		JunitString junitStudy = new JunitString();
		int[] expected = {1, 2};
		int[] actual = junitStudy.splitIntArray("1,2");
		assertArrayEquals(expected, actual, "testSplit1 faild");
	}

	@Test
	public void testSplitIntArray1_2() {
		JunitString junitStudy = new JunitString();
		int[] actual = junitStudy.splitIntArray("1,2");
		assertThat(actual).contains(1, 2);
	}

	// String 요구사항1-2
	// 1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	@Test
	public void testSplitIntArray2() {
		JunitString junitStudy = new JunitString();
		int[] actual = junitStudy.splitIntArray("1");
		assertThat(actual).containsExactly(1);
	}

}
