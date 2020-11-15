package baseball.core;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {
	private static Round round;

	@BeforeAll
	public static void beforeAll() {
		round = new Round();
	}

	@Test
	@DisplayName("0이상 양수에 자릿수 확인")
	public void round_numberLength() {
		assertEquals(1, round.numberLength(1));
		assertEquals(2, round.numberLength(12));
		assertEquals(3, round.numberLength(123));
		assertEquals(4, round.numberLength(1234));
		assertEquals(5, round.numberLength(12345));
	}

	@Test
	@DisplayName("첫번째 인덱스에 해당하는 자릿에 해당하는 값 추출")
	public void round_getPlaceValue1() {
		int index = 0;

		assertEquals(1, round.getPlaceValue(1, index));
		assertEquals(1, round.getPlaceValue(12, index));
		assertEquals(1, round.getPlaceValue(123, index));
		assertEquals(9, round.getPlaceValue(9, index));
		assertEquals(9, round.getPlaceValue(98, index));
		assertEquals(9, round.getPlaceValue(987, index));
	}

	@Test
	@DisplayName("두번째 인덱스에 해당하는 자릿에 해당하는 값 추출")
	public void round_getPlaceValue2() {
		int index = 1;

		assertEquals(2, round.getPlaceValue(12, index));
		assertEquals(2, round.getPlaceValue(123, index));
		assertEquals(8, round.getPlaceValue(98, index));
		assertEquals(8, round.getPlaceValue(987, index));
	}

	@Test
	@DisplayName("세번째 인덱스에 해당하는 자릿에 해당하는 값 추출")
	public void round_getPlaceValue3() {
		int index = 2;

		assertEquals(3, round.getPlaceValue(123, index));
		assertEquals(7, round.getPlaceValue(987, index));
	}

	@Test
	@DisplayName("인덱스가 자릿값 길이보다 같거나 긴경우 예외발생")
	public void round_get_throw() {
		Assertions.assertThatIllegalArgumentException().isThrownBy(() -> round.getPlaceValue(1, 10));
		Assertions.assertThatIllegalArgumentException().isThrownBy(() -> round.getPlaceValue(123, 3));
	}
}
