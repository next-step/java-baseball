package baseball;

import static org.assertj.core.api.Assertions.*;
import static baseball.GetPlayerNumber.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GetPlayerNumberTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new LinkedHashSet<>();
		numbers.add(6);
		numbers.add(3);
		numbers.add(3);
		numbers.add(9);
	}

	@Test
	void getPlayerNumberTest() {
		assertThat(getPlayerNumber("639")).isEqualTo(numbers);
		assertThat(getPlayerNumber("12a")).isNull();
		assertThat(getPlayerNumber("663")).isNull();
		assertThat(getPlayerNumber("6339")).isNull();
	}

	@Test
	void inputValidationSizeTest() {
		assertThat(inputValidationSize(numbers.size())).isEqualTo(true);
		assertThat(inputValidationSize(splitString("123").length)).isEqualTo(true);

	}

	@Test
	void splitStringTest() {
		assertThat(splitString("123")).containsExactly("1", "2", "3");
		assertThat(splitString("654")).containsExactly("6", "5", "4");
	}

	@Test
	void addLinkedHashSetTest() {
		assertThat(addLinkedHashSet(new String[] {"6", "3", "9"})).isEqualTo(numbers);

		assertThatThrownBy(() -> {
			addLinkedHashSet(new String[] {"6", "3", "a"});
		}).isInstanceOf(NumberFormatException.class)
			.hasMessageContaining("For input string: ");
	}

	@Test
	void convertFromStringToHashSetTest() {
		assertThat(convertFromStringToHashSet(new String[] {"6", "3", "9"})).isEqualTo(numbers);
		assertThat(convertFromStringToHashSet(new String[] {"6", "3", "a"})).isNull();
	}

	@Test
	void convertFromStringToIntegerTest() {
		assertThatThrownBy(() -> {
			convertFromStringToInteger("a");
		}).isInstanceOf(NumberFormatException.class)
			.hasMessageContaining("For input string: ");

		assertThat(convertFromStringToInteger("1")).isEqualTo(1);
	}

	// @ParameterizedTest
	// @CsvSource(value = {"1a, false", "12b, false", "b, false", "bbb, false", "123, true"})
	// void inputValiationHasOnlyNumber(String input, Boolean expected) {
	// 	assertEquals(inputValidation(input), expected);
	// }

}
