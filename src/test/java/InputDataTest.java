import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import NumberBaseballGame.InputData;

class InputDataTest {

	InputData inputData;

	@BeforeEach
	void setup() {
		inputData = new InputData();
	}

	@DisplayName("입력데이터 길이가 세자리인지 확인")
	@Test
	void inputDataLengthThree() {
		assertFalse(inputData.isValidInputData("2930123"));
		assertFalse(inputData.isValidInputData("29"));

		assertTrue(inputData.isValidInputData("293"));
	}

	@DisplayName("1~9만 입력 가능")
	@Test
	void numberRange() {
		assertFalse(inputData.isValidInputData("jki"));
		assertFalse(inputData.isValidInputData("120"));
		assertFalse(inputData.isValidInputData("2*9"));
	}

	@DisplayName("중복 입력 확인")
	@Test
	void checkDuplicateInput() {
		assertTrue(inputData.isDuplicateInput("777"));
		assertTrue(inputData.isDuplicateInput("779"));
		assertFalse(inputData.isDuplicateInput("712"));
	}

	@DisplayName("동일 입력 숫자 갯수 확인")
	@Test
	void checkDuplicateInputCount() {
		assertEquals(3, inputData.containsCount("777", "7"));
		assertEquals(2, inputData.containsCount("779", "7"));
		assertEquals(1, inputData.containsCount("712", "7"));
	}

	@DisplayName("입력데이터 변환 확인(String -> int[3]")
	@Test
	void checkString2IntArray() {
		assertEquals(3, inputData.splitInputData("213").length);
	}

}
