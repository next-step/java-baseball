package util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomUtilTest {

	@Test
	public void has3Digit() {
		int[] randomResult = RandomUtil.getRandom3DigitWithoutDuplicates();
		assertThat(randomResult).hasSize(3);
	}

	@Test
	public void hasNonZeroOnly() {
		int[] randomResult = RandomUtil.getRandom3DigitWithoutDuplicates();
		assertThat(randomResult).doesNotContain(0);
	}

	@Test
	public void hasDifferentNumbers() {
		int[] randomResult = RandomUtil.getRandom3DigitWithoutDuplicates();
		assertThat(randomResult).doesNotHaveDuplicates();
	}

}
