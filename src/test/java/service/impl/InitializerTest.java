package service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import service.IInitializer;

class InitializerTest {

	private final IInitializer initializer = new Initializer();

	@Test
	@DisplayName("컴퓨터 초기 숫자 테스트")
	void initComputerNumbers() {

		/// region given
		final int expectedSize = 3;
		/// endregion

		/// region when
		final Map<Integer, Integer> actualComputerNumbers = initializer.initComputerNumbers();
		/// endregion

		/// region then
		assertNotNull(actualComputerNumbers);
		assertEquals(expectedSize, actualComputerNumbers.size());
		/// endregion
	}
}
