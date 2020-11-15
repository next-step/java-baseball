import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseBallTest {

	@Test
	@DisplayName("각 자리가 중복되는 경우, 중복 검사(isEachNumberUniqueAndThreeDigitNumber) 함수 테스트")
	public void isEachNumberUniqueAndThreeDigitNumberTest() {
		assertAll(
			() -> assertFalse(isEachNumberUniqueAndThreeDigitNumber("232")),
			() -> assertFalse(isEachNumberUniqueAndThreeDigitNumber("554")),
			() -> assertFalse(isEachNumberUniqueAndThreeDigitNumber("499")),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber("369")),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber("519")),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber("932"))
		);
	}

	@Test
	@DisplayName("각 자리가 중복되지 않는 세자리 수가 만들어지는지 테스트")
	public void makeRandomNumberStringTest() {
		NumberBaseBall numberBaseBall = new NumberBaseBall();

		assertAll(
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString())),
			() -> assertTrue(isEachNumberUniqueAndThreeDigitNumber(numberBaseBall.makeRandomNumberString()))
		);
	}

	@Test
	@DisplayName("3볼 결과 메시지")
	public void makeResultTest_When_3Ball() {
		NumberBaseBall numberBaseBall = new NumberBaseBall();
		String result = numberBaseBall.calculate("352", "235");
		assertEquals(result, "3볼");
	}

	@Test
	@DisplayName("3스트라이크 결과 메시지")
	public void makeResultTest_When_3Strike() {
		NumberBaseBall numberBaseBall = new NumberBaseBall();
		String result = numberBaseBall.calculate("352", "352");
		assertEquals(result, "3스트라이크 ");
	}

	@Test
	@DisplayName("1스트라이크 2볼 결과 메시지")
	public void makeResultTest_When_1Strike_2Ball() {
		NumberBaseBall numberBaseBall = new NumberBaseBall();
		String result = numberBaseBall.calculate("352", "253");
		assertEquals(result, "1스트라이크 2볼");
	}

	@Test
	@DisplayName("하나도 안맞은 경우 결과 메시지")
	public void makeResultTest_When_Nothing() {
		NumberBaseBall numberBaseBall = new NumberBaseBall();
		String result = numberBaseBall.calculate("352", "987");
		assertEquals(result, "낫싱");
	}

	private boolean isEachNumberUniqueAndThreeDigitNumber(String numberString) {
		String[] numbers = numberString.split("");
		Set<String> numberSet = new HashSet<>(Arrays.asList(numbers));
		return numberSet.size() == 3;
	}
}
