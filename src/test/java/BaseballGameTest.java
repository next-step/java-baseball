import model.ExceptionMessageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {

	static ArrayList<String> defaultNumbers = new ArrayList<>();
	static ArrayList<String> userInputNumbers = new ArrayList<>();

	@BeforeAll
	static void setup() {
		System.out.println("start test case");
	}

	@DisplayName("컴퓨터가 사용할 번호 뽑기 정상 케이스")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	void pickNumber_isOk(String input) {
		int convertIntegerFromString = Integer.parseInt(input);

		assertTrue((convertIntegerFromString < 10 && convertIntegerFromString > 0));
		assertFalse(defaultNumbers.contains(input));

		defaultNumbers.add(input);
	}

	@DisplayName("컴퓨터가 사용할 번호 뽑기 중복된 경우")
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	void pickNumber_isDuplicate(String input) {
		ArrayList<String> tempArray = new ArrayList<>(Arrays.asList("1", "2"));
		int convertIntegerFromString = Integer.parseInt(input);

		assertTrue((convertIntegerFromString < 10 && convertIntegerFromString > 0));

		Throwable exception = assertThrows(InvalidParameterException.class,
				() -> checkDuplicationNumberFromInput(tempArray, String.valueOf(convertIntegerFromString)));

		assertEquals(ExceptionMessageEnum.INVALID.getMessage(), exception.getMessage());
	}

	@DisplayName("컴퓨터가 사용할 번호 뽑기 NULL OR Blank 값의 경우")
	@NullAndEmptySource
	@ParameterizedTest
	@ValueSource(strings = {" "})
	void pickNumber_isNULL_isBlank(String input) {
		Throwable exception = assertThrows(CustomExceptionTest.class,
				() -> checkNullOrBlankStringFromInput(input));
		assertEquals(ExceptionMessageEnum.NULL_OR_BLANK.getMessage(), exception.getMessage());
	}

	@Test
	@DisplayName("컴퓨터가 사용할 번호 뽑기 리스트 사이즈가 다른 경우")
	void pickNumber_isInvalidSize() {
		ArrayList<String> tempArray = new ArrayList<>(Arrays.asList("1", "2"));

		Throwable exception = assertThrows(CustomExceptionTest.class,
				() -> checkNumberListSize(tempArray));
		assertEquals(ExceptionMessageEnum.INVALID_SIZE.getMessage(), exception.getMessage());
	}

	@DisplayName("사용자로부터 받은 번호 검증 정상")
	@ParameterizedTest
	@ValueSource(strings = {"123"})
	void checkNumberFromUserInput_isOk(String input) {
		ArrayList<String> compareArray = new ArrayList<>(Arrays.asList("1", "2", "3"));
		assertEquals(input.length(), 3);

		for (char number : input.toCharArray()) {
			int convertNumberFromChar = Integer.parseInt(convertCharToString(number));
			assertTrue((convertNumberFromChar < 10 && convertNumberFromChar > 0));
			userInputNumbers.add(String.valueOf(number));
		}

		assertEquals(userInputNumbers.size(), 3);
		assertArrayEquals(userInputNumbers.toArray(), compareArray.toArray());
	}

	@DisplayName("사용자로부터 받은 번호 검증 중복")
	@ParameterizedTest
	@ValueSource(strings = {"113"})
	void checkNumberFromUserInput_isDuplicate(String input) {
		assertEquals(input.length(), 3);

		Throwable exception = assertThrows(CustomExceptionTest.class,
				() -> checkDuplicationNumberFromUserInput(input));

		assertEquals(ExceptionMessageEnum.DUPLICATE.getMessage(), exception.getMessage());
	}

	@DisplayName("사용자로부터 받은 번호 검증 사이즈 잘못되었을때")
	@ParameterizedTest
	@ValueSource(strings = {"12", "13", "1"})
	void checkNumberFromUserInput_sizeIsNotValid(String input) {
		Throwable exception = assertThrows(CustomExceptionTest.class,
				() -> checkNumberStringSize(input));

		assertEquals(ExceptionMessageEnum.INVALID_SIZE.getMessage(), exception.getMessage());
	}

	@DisplayName("사용자로부터 받은 번호 검증 숫자가 아닐경우")
	@ParameterizedTest
	@ValueSource(strings = {"A", " ", ""})
	void checkNumberFromUserInput_isNotInteger(String input) {
		ArrayList<String> tempArray = new ArrayList<>();
		Assertions.assertThrows(NumberFormatException.class, () -> tempArray.add(String.valueOf(Integer.parseInt(input))));

		assertEquals(tempArray.size(), 0);
	}

	@Test
	void showGameResult_strike1_ball2() {
		ArrayList<String> computerNumbers = new ArrayList<>(Arrays.asList("1", "3", "2"));
		ArrayList<String> userNumbers = new ArrayList<>(Arrays.asList("1", "2", "3"));

		int strike = isStrike(computerNumbers, userNumbers);
		int ball = isBall(computerNumbers, userNumbers);

		assertEquals(strike, 1);
		assertEquals(ball, 2);
	}

	@Test
	void showGameResult_strike2_noBall() {
		ArrayList<String> computerNumbers = new ArrayList<>(Arrays.asList("1", "6", "3"));
		ArrayList<String> userNumbers = new ArrayList<>(Arrays.asList("1", "2", "3"));

		int strike = isStrike(computerNumbers, userNumbers);
		int ball = isBall(computerNumbers, userNumbers);

		assertEquals(strike, 2);
		assertEquals(ball, 0);
	}

	@Test
	void showGameResult_strike3_noBall() {
		ArrayList<String> computerNumbers = new ArrayList<>(Arrays.asList("1", "2", "3"));
		ArrayList<String> userNumbers = new ArrayList<>(Arrays.asList("1", "2", "3"));

		int strike = isStrike(computerNumbers, userNumbers);
		int ball = isBall(computerNumbers, userNumbers);

		assertEquals(strike, 3);
		assertEquals(ball, 0);
	}

	private void checkDuplicationNumberFromInput(ArrayList<String> originArray, String input) {
		if (originArray.contains(input)) {
			throw new InvalidParameterException(ExceptionMessageEnum.INVALID.getMessage());
		}
	}

	private void checkNullOrBlankStringFromInput(String input) throws CustomExceptionTest {
		if (StringUtils.isBlank(input)) {
			throw new CustomExceptionTest(ExceptionMessageEnum.NULL_OR_BLANK.getMessage());
		}
	}

	private void checkNumberListSize(ArrayList<String> input) throws CustomExceptionTest {
		if (input.size() != 3) {
			throw new CustomExceptionTest(ExceptionMessageEnum.INVALID_SIZE.getMessage());
		}
	}

	private void checkDuplicationNumberFromUserInput(String input) throws CustomExceptionTest {
		LinkedHashSet<String> linkedHashMap = new LinkedHashSet<>();

		for (char number : input.toCharArray()) {
			linkedHashMap.add(convertCharToString(number));
		}

		if (linkedHashMap.size() < 3) {
			throw new CustomExceptionTest(ExceptionMessageEnum.DUPLICATE.getMessage());
		}
	}

	private void checkNumberStringSize(String input) throws CustomExceptionTest {
		if (input.length() != 3) {
			throw new CustomExceptionTest(ExceptionMessageEnum.INVALID_SIZE.getMessage());
		}
	}

	private String convertCharToString(char input) {
		return String.valueOf(input);
	}

	private int isStrike(ArrayList<String> defaultNumbers,
						 ArrayList<String> userInputNumbers) {
		int strikeCount = 0;

		for (String number : defaultNumbers) {
			strikeCount += (userInputNumbers.get(defaultNumbers.indexOf(number)).equals(number)) ?
					1 : 0;
		}

		return strikeCount;
	}

	private int isBall(ArrayList<String> defaultNumbers,
					   ArrayList<String> userInputNumbers) {
		return compareCountOfBall(defaultNumbers, userInputNumbers);
	}

	private ArrayList<String> arrayDeepCopy(ArrayList<String> baseArray) {
		String[] copyArray = new String[baseArray.size()];
		System.arraycopy(
				baseArray.toArray(),
				0,
				copyArray,
				0,
				baseArray.size());

		return new ArrayList<>(Arrays.asList(copyArray));
	}

	private int compareCountOfBall(ArrayList<String> defaultNumbers,
								   ArrayList<String> userInputNumbers) {
		int userInputSize = userInputNumbers.size();
		int ballCount = 0;

		for (int i = 0; i < userInputSize; i++) {
			ArrayList<String> compareArray = arrayDeepCopy(defaultNumbers);
			compareArray.remove(i);
			ballCount += (compareArray.contains(userInputNumbers.get(i))) ? 1 : 0;
		}

		return ballCount;
	}
}
