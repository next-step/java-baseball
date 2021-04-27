package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

	@Test
	public void convertStringToIntegerList_WhenCalled_ReturnIntegerList() {
		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> actual = StringUtil.convertStringToIntegerList("123");
		assertEquals(expected, actual);
	}

}