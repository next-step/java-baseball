package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

	@Test
	void stringToIntegerListDelimiter() {
		assertThat(StringUtil.stringToIntegerListWithDelimiter("0,0,0")).containsExactly(0, 0, 0);
		assertThat(StringUtil.stringToIntegerListWithDelimiter("1,2,3")).containsExactly(1, 2, 3);
		assertThat(StringUtil.stringToIntegerListWithDelimiter("9,8,7")).containsExactly(9, 8, 7);

		assertThat(StringUtil.stringToIntegerListWithDelimiter("0:0:0", ":")).containsExactly(0, 0, 0);
		assertThat(StringUtil.stringToIntegerListWithDelimiter("1:2:3", ":")).containsExactly(1, 2, 3);
		assertThat(StringUtil.stringToIntegerListWithDelimiter("9:8:7", ":")).containsExactly(9, 8, 7);

		assertThat(StringUtil.stringToIntegerList("000")).containsExactly(0, 0, 0);
		assertThat(StringUtil.stringToIntegerList("123")).containsExactly(1, 2, 3);
		assertThat(StringUtil.stringToIntegerList("987")).containsExactly(9, 8, 7);
	}
}
