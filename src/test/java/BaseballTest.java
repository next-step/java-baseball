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

import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {

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
		Throwable exception = assertThrows(CustomException.class,
				() -> checkNullOrBlankStringFromInput(input));
		assertEquals(ExceptionMessageEnum.NULL_OR_BLANK.getMessage(), exception.getMessage());
	}

	@Test
	@DisplayName("컴퓨터가 사용할 번호 뽑기 리스트 사이즈가 다른 경우")
	void pickNumber_isInvalidSize() {
		ArrayList<String> tempArray = new ArrayList<>(Arrays.asList("1", "2"));

		Throwable exception = assertThrows(CustomException.class,
				() -> checkNumberListSize(tempArray));
		assertEquals(ExceptionMessageEnum.INVALID_SIZE.getMessage(), exception.getMessage());
	}

	private void checkDuplicationNumberFromInput(ArrayList<String> originArray, String inputNumber) {
		if (originArray.contains(inputNumber)) {
			throw new InvalidParameterException(ExceptionMessageEnum.INVALID.getMessage());
		}
	}

	private void checkNullOrBlankStringFromInput(String input) throws CustomException {
		if (StringUtils.isBlank(input)) {
			throw new CustomException(ExceptionMessageEnum.NULL_OR_BLANK.getMessage());
		}
	}

	private void checkNumberListSize(ArrayList<String> inputNumbers) throws CustomException {
		if (inputNumbers.size() != 3) {
			throw new CustomException(ExceptionMessageEnum.INVALID_SIZE.getMessage());
		}
	}
}
