package baseball.core;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RoundTest {
	private static Round round;
	private Map<GameStatus, Integer> resultCountMap;

	@BeforeAll
	public static void beforeAll() {
		round = new Round(123);
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

	@Test
	@DisplayName("특정한 값이 랜덤값 3자리에 포함하는지 여부")
	public void isExsit() {
		Round round = new Round(123);
		assertTrue(round.isExsit(1));
		assertTrue(round.isExsit(2));
		assertTrue(round.isExsit(3));
		assertFalse(round.isExsit(4));
		assertFalse(round.isExsit(5));
		assertFalse(round.isExsit(6));
		assertFalse(round.isExsit(7));
		assertFalse(round.isExsit(8));
		assertFalse(round.isExsit(9));
	}

	@ParameterizedTest
	@ValueSource(ints = {0})
	@DisplayName("첫번째 자릿값이 특정한 값과 같은지 여부")
	public void isPlaceExsit1(int index) {
		Round round = new Round(123);
		assertTrue(round.isPlaceExsit(1, index));
		assertFalse(round.isPlaceExsit(2, index));
		assertFalse(round.isPlaceExsit(3, index));
		assertFalse(round.isPlaceExsit(4, index));
		assertFalse(round.isPlaceExsit(5, index));
		assertFalse(round.isPlaceExsit(6, index));
		assertFalse(round.isPlaceExsit(7, index));
		assertFalse(round.isPlaceExsit(8, index));
		assertFalse(round.isPlaceExsit(9, index));
	}

	@ParameterizedTest
	@ValueSource(ints = {1})
	@DisplayName("두번째 자릿값이 특정한 값과 같은지 여부")
	public void isPlaceExsit2(int index) {
		Round round = new Round(123);
		assertFalse(round.isPlaceExsit(1, index));
		assertTrue(round.isPlaceExsit(2, index));
		assertFalse(round.isPlaceExsit(3, index));
		assertFalse(round.isPlaceExsit(4, index));
		assertFalse(round.isPlaceExsit(5, index));
		assertFalse(round.isPlaceExsit(6, index));
		assertFalse(round.isPlaceExsit(7, index));
		assertFalse(round.isPlaceExsit(8, index));
		assertFalse(round.isPlaceExsit(9, index));
	}

	@ParameterizedTest
	@ValueSource(ints = {2})
	@DisplayName("세번째 자릿값이 특정한 값과 같은지 여부")
	public void isPlaceExsit3(int index) {
		Round round = new Round(123);
		assertFalse(round.isPlaceExsit(1, index));
		assertFalse(round.isPlaceExsit(2, index));
		assertTrue(round.isPlaceExsit(3, index));
		assertFalse(round.isPlaceExsit(4, index));
		assertFalse(round.isPlaceExsit(5, index));
		assertFalse(round.isPlaceExsit(6, index));
		assertFalse(round.isPlaceExsit(7, index));
		assertFalse(round.isPlaceExsit(8, index));
		assertFalse(round.isPlaceExsit(9, index));
	}

	@Test
	@DisplayName("의도하지 않은 생성자 파리미터 예외발생")
	public void initRound() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Round(1);
		}).withMessage("%s자리 자릿수에 해당하는 숫자를 넘겨주시기 바랍니다.", 3);
	}

	@ParameterizedTest
	@ValueSource(ints = {456, 789, 489, 459, 784, 768})
	@DisplayName("제시한 값에 점수확인")
	public void getGameStatusCountMap1(int num) {
		Map<GameStatus, Integer> resultCountMap = round.getGameStatusCountMap(num);

		assertEquals(resultCountMap.get(GameStatus.STRIKE), 0);
		assertEquals(resultCountMap.get(GameStatus.BOLL), 0);
	}

	@Test
	@DisplayName("제시한 값에 점수확인")
	public void getGameStatusCountMap2() {

		resultCountMap = round.getGameStatusCountMap(123);
		assertEquals(resultCountMap.get(GameStatus.STRIKE), 3);
		assertEquals(resultCountMap.get(GameStatus.BOLL), 0);
	}

	@Test
	@DisplayName("제시한 값에 점수확인")
	public void getGameStatusCountMap3() {

		resultCountMap = round.getGameStatusCountMap(231);
		assertEquals(resultCountMap.get(GameStatus.STRIKE), 0);
		assertEquals(resultCountMap.get(GameStatus.BOLL), 3);
	}

	@Test
	@DisplayName("제시한 값에 점수확인")
	public void getGameStatusCountMap4() {

		resultCountMap = round.getGameStatusCountMap(142);
		assertEquals(resultCountMap.get(GameStatus.STRIKE), 1);
		assertEquals(resultCountMap.get(GameStatus.BOLL), 1);
	}

}
