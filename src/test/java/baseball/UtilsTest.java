package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UtilsTest {

	@Test
	void stringToIntegerListDelimiter() {
		assertThat(Utils.stringToIntegerListWithDelimiter("0,0,0")).containsExactly(0, 0, 0);
		assertThat(Utils.stringToIntegerListWithDelimiter("1,2,3")).containsExactly(1, 2, 3);
		assertThat(Utils.stringToIntegerListWithDelimiter("9,8,7")).containsExactly(9, 8, 7);

		assertThat(Utils.stringToIntegerListWithDelimiter("0:0:0", ":")).containsExactly(0, 0, 0);
		assertThat(Utils.stringToIntegerListWithDelimiter("1:2:3", ":")).containsExactly(1, 2, 3);
		assertThat(Utils.stringToIntegerListWithDelimiter("9:8:7", ":")).containsExactly(9, 8, 7);

		assertThat(Utils.stringToIntegerList("000")).containsExactly(0, 0, 0);
		assertThat(Utils.stringToIntegerList("123")).containsExactly(1, 2, 3);
		assertThat(Utils.stringToIntegerList("987")).containsExactly(9, 8, 7);
	}
}
