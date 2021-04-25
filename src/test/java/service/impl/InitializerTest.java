package service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import common.argumentprovider.InvalidPlayerInputArgumentsProvider;
import exception.InvalidValueException;
import service.IInitializer;

class InitializerTest {

	private final IInitializer initializer = new Initializer();

	@Test
	@DisplayName("컴퓨터 초기 숫자 세팅 테스트")
	void testInitComputerNumber() {

		/// region given
		final int expectedSize = 3;
		/// endregion

		/// region when
		final Map<Integer, Integer> actualComputerNumbers = initializer.initComputerNumber();
		/// endregion

		/// region then
		assertNotNull(actualComputerNumbers);
		assertEquals(expectedSize, actualComputerNumbers.size());
		/// endregion
	}

	@DisplayName("플레이어가 제시한 유효하지 않은 숫자 테스트")
	@ArgumentsSource(InvalidPlayerInputArgumentsProvider.class)
	@ParameterizedTest(name = "입력 받은 숫자: {0}")
	void testInitInvalidPlayerNumber(final String title, final int givenInput) {

		/// region given
		final Throwable expectedException = new InvalidValueException();
		/// endregion

		/// region when
		final Throwable actualException = assertThrows(
			expectedException.getClass(),
			() -> initializer.initPlayerNumber(givenInput)
		);
		/// endregion

		/// region then
		assertEquals(expectedException.getClass(), actualException.getClass());
		/// endregion
	}

	@DisplayName("플레이어가 제시한 숫자 세팅 테스트")
	@Test
	void testInitPlayerNumber() {

		/// region given
		final int givenInput = 123;
		final int[] expectedPlayerNumber = {1, 2, 3};
		/// endregion

		/// region when
		final int[] actualPlayerNumber = initializer.initPlayerNumber(givenInput);
		/// endregion

		/// region then
		assertNotNull(actualPlayerNumber);
		assertEquals(expectedPlayerNumber.length, actualPlayerNumber.length);
		for (int i = 0; i < 3; i++) {
			assertEquals(expectedPlayerNumber[i], actualPlayerNumber[i]);
		}
		/// endregion
	}
}
