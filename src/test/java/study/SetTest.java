package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("요구사항 1. Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
	public void size() {
		int size = numbers.size();

		assertEquals(size, 3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("요구사항 2. Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 테스트")
	public void contains_ShouldReturnTrueIfContains(int input) {
		boolean containsResult = numbers.contains(input);

		assertThat(containsResult).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':') //default : ','
	@DisplayName("요구사항 3. 요구사항2에서 입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
	public void contains_ShouldReturnTrueIfCorrectAnswer(int inputNumber, boolean inputAnswer) {
		boolean containsResult = numbers.contains(inputNumber);

		assertEquals(containsResult, inputAnswer);
	}
}
