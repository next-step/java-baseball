package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {
	@Test
	@DisplayName("String 객체를 delimiter를 구분자로 하여 List<Integer> 형태로 변환")
	public void isConverCorrectlyFromStringToIntegerList() {
		String inputStr = "4,5,6";
		String delimiter = ",";
		List<Integer> answer = new ArrayList<>();
		answer.add(4);
		answer.add(5);
		answer.add(6);

		List<Integer> InputNumbers = Converter.convertStringToIntegerList(inputStr, delimiter);
		assertEquals(answer, InputNumbers);
	}
}
