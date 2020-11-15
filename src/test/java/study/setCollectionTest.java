package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class setCollectionTest {
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
	@DisplayName("size 메소드 활용 학습테스트 ")
	void sizeTest(){
		assertThat(numbers.size()).isEqualTo(3);
	}
	@Test
	@DisplayName("1,2,3 의 값이 존재하는지 확인 학습테스트 ")
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	@DisplayName("중복코드 제거 활용 학습테스트 ")
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(int input) {
		assertTrue(numbers.contains(input));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true","4:false", "5:false"}, delimiter = ':')
	@DisplayName("중복코드 제거 활용 학습테스트2 ")
	void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int input, boolean expected) {

		assertEquals(numbers.contains(input), expected);
	}
}
