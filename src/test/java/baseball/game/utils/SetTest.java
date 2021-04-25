/*
 * @(#) SetTest.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.utils;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author 박준영
 **/
public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
	}

	@Test
	@DisplayName("요구사항1")
	void checkSize() {
		Assertions.assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("요구사항2")
	void contains() {
		Assertions.assertThat(numbers.contains(1)).isTrue();
		Assertions.assertThat(numbers.contains(2)).isTrue();
		Assertions.assertThat(numbers.contains(3)).isTrue();
	}

	@Test
	@DisplayName("요구사항2")
	@ParameterizedTest()
	@ValueSource(ints = {1,2,3})
	void containsNotDuplicated(int input) {
		Assertions.assertThat(numbers.contains(input)).isTrue();
	}

	@Test
	@DisplayName("요구사항4")
	@ParameterizedTest()
	@CsvSource( value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
	void contatinsTest(int input, boolean expect) {
		Assertions.assertThat(numbers.contains(input)).isEqualTo(expect);
	}

}
