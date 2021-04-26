package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomUtilTest {
	@ParameterizedTest
	@ValueSource(chars = {3, 5, 9})
	public void createNonDuplicatedRandomArr_WhenCalled_ShouldReturnSizedArr(int size) {
		List<Integer> result = RandomUtil.createNonDuplicatedNumberList(size);
		assertThat(result.size()).isEqualTo(size);
	}

	@ParameterizedTest
	@ValueSource(ints = {3, 5, 9})
	public void createNonDuplicatedRandomArr_WhenCalled_ShouldReturnNonDuplicatedArr(int size) {
		List<Integer> result = RandomUtil.createNonDuplicatedNumberList(size);
		assertThat(Collections.singletonList(result)).doesNotHaveDuplicates();
	}

	@ParameterizedTest
	@ValueSource(ints = {3, 5, 9})
	public void createNonDuplicatedRandomArr_WhenCalled_ShouldReturnOneToNineArr(int size) {
		List<Integer> result  = RandomUtil.createNonDuplicatedNumberList(size);
		for (int i : result) {
			assertThat(i > 0 && i < 10).isTrue();
		}
	}
}