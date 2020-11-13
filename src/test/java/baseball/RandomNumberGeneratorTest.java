package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class RandomNumberGeneratorTest {

	@Test
	void generate() {
		assertThat(RandomNumberGenerator.generate())
			.isNotEmpty()
			.hasSize(3)
			.doesNotHaveDuplicates()
			.allSatisfy(i -> assertTrue(i >= 1 && i <= 9));
	}

}