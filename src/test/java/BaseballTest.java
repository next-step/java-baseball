import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {

	private static ArrayList<String> numbers = new ArrayList<>();

	@BeforeAll
	static void setup() {
		System.out.println("start test case");
	}

	@DisplayName("컴퓨터가 사용할 번호 뽑기")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	void pickNumber (String input) {
		int convertIntegerFromString = Integer.parseInt(input);

		assertTrue((convertIntegerFromString < 10 && convertIntegerFromString > 0));
		assertFalse(numbers.contains(input));

		numbers.add(input);
	}
}
