package baseball.core;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RoundTest {
	private static Round round;
	private Map<GameStatus, Integer> resultCountMap;

	@BeforeAll
	public static void beforeAll() {
		round = new Round(123);
	}

	@DisplayName("0이상 양수에 자릿수 확인")
	@ParameterizedTest
	@CsvSource({"1,1", "12,2", "123,3", "1234,4", "12345,5"})
	public void round_numberLength(int input, int expected) {
		assertThat(round.numberLength(input)).isEqualTo(expected);
	}

	@DisplayName("첫번째 인덱스에 해당하는 자릿에 해당하는 값 추출")
	@ParameterizedTest
	@CsvSource({"1,1", "12,1", "123,1", "9,9", "98,9", "987,9"})
	public void round_getPlaceValue1(int input, int expected) {
		int index = 0;

		assertEquals(expected, round.getPlaceValue(input, index));
	}

	@DisplayName("두번째 인덱스에 해당하는 자릿에 해당하는 값 추출")
	@ParameterizedTest
	@CsvSource({"12,2", "123,2", "98,8", "987,8"})
	public void round_getPlaceValue2(int input, int expected) {
		int index = 1;

		assertEquals(expected, round.getPlaceValue(input, index));
	}

	@DisplayName("세번째 인덱스에 해당하는 자릿에 해당하는 값 추출")
	@ParameterizedTest
	@CsvSource({"123,3", "987,7"})
	public void round_getPlaceValue3(int input, int expected) {
		int index = 2;

		assertEquals(expected, round.getPlaceValue(input, index));
	}

	@Test
	@DisplayName("인덱스가 자릿값 길이보다 같거나 긴경우 예외발생")
	public void round_get_throw() {
		Assertions.assertThatIllegalArgumentException().isThrownBy(() -> round.getPlaceValue(1, 10));
		Assertions.assertThatIllegalArgumentException().isThrownBy(() -> round.getPlaceValue(123, 3));
	}

	@DisplayName("특정한 값이 랜덤값 3자리에 포함하는지 여부")
	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false", "6,false", "7,false", "8,false", "9,false"})
	public void isExsit(int input, boolean expected) {
		Round round = new Round(123);

		assertThat(round.isExsit(input)).isEqualTo(expected);
	}


	@DisplayName("첫번째 자릿값이 특정한 값과 같은지 여부")
	@ParameterizedTest
	@CsvSource({"1,true", "2,false", "3,false", "4,false", "5,false", "6,false", "7,false", "8,false", "9,false"})
	public void isPlaceExsit1(int input, boolean expected) {
		Round round = new Round(123);

		assertThat(round.isPlaceExsit(input, 0)).isEqualTo(expected);
	}

	@DisplayName("두번째 자릿값이 특정한 값과 같은지 여부")
	@ParameterizedTest
	@CsvSource({"1,false", "2,true", "3,false", "4,false", "5,false", "6,false", "7,false", "8,false", "9,false"})
	public void isPlaceExsit2(int input, boolean expected) {
		Round round = new Round(123);

		assertThat(round.isPlaceExsit(input, 1)).isEqualTo(expected);
	}

	@DisplayName("세번째 자릿값이 특정한 값과 같은지 여부")
	@ParameterizedTest
	@CsvSource({"1,false", "2,false", "3,true", "4,false", "5,false", "6,false", "7,false", "8,false", "9,false"})
	public void isPlaceExsit3(int input, boolean expected) {
		Round round = new Round(123);

		assertThat(round.isPlaceExsit(input, 2)).isEqualTo(expected);
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

		assertThat(0).isEqualTo(resultCountMap.get(GameStatus.STRIKE));
		assertThat(0).isEqualTo(resultCountMap.get(GameStatus.BOLL));
	}

	@Test
	@DisplayName("제시한 값에 점수확인")
	public void getGameStatusCountMap2() {
		resultCountMap = round.getGameStatusCountMap(123);

		assertThat(3).isEqualTo(resultCountMap.get(GameStatus.STRIKE));
		assertThat(0).isEqualTo(resultCountMap.get(GameStatus.BOLL));
	}

	@Test
	@DisplayName("제시한 값에 점수확인")
	public void getGameStatusCountMap3() {
		resultCountMap = round.getGameStatusCountMap(231);

		assertThat(0).isEqualTo(resultCountMap.get(GameStatus.STRIKE));
		assertThat(3).isEqualTo(resultCountMap.get(GameStatus.BOLL));
	}

	@Test
	@DisplayName("제시한 값에 점수확인")
	public void getGameStatusCountMap4() {
		resultCountMap = round.getGameStatusCountMap(142);

		assertThat(1).isEqualTo(resultCountMap.get(GameStatus.STRIKE));
		assertThat(1).isEqualTo(resultCountMap.get(GameStatus.BOLL));
	}

}
