package home.work.baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.Test;

class RandomUtilsTest {

	@Test
	final void testGenerateNums() {
		int size = 5;
		List<Integer> result = RandomUtils.generateNums(size);
		assertThat(result).isNotNull().hasSize(size).doesNotHaveDuplicates();
	}
	
	@Test
	public void testgenerateNumsWrongSize() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
				RandomUtils.generateNums(10);
			})
			.withMessage("1 ~ 9개 숫자만 가능합니다.");
	}

}
