package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UtilsTest {

	@Test
	void stringToIntegerList() {
		assertThat(Utils.stringToIntegerList("0,0,0")).containsExactly(0, 0, 0);
		assertThat(Utils.stringToIntegerList("1,2,3")).containsExactly(1, 2, 3);
		assertThat(Utils.stringToIntegerList("9,8,7")).containsExactly(9, 8, 7);
	}
}
