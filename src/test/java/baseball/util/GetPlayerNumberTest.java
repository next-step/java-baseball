package baseball.util;

import static baseball.util.GetPlayerNumber.*;
import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void inputValidationRangeTest() {
		assertThatThrownBy(() -> {
			inputValidationRange(0);
		}).isInstanceOf(NumberFormatException.class)
			.hasMessageContaining("number must be between 1 and 9");

		assertThatThrownBy(() -> {
			inputValidationRange(10);
		}).isInstanceOf(NumberFormatException.class)
			.hasMessageContaining("number must be between 1 and 9");

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

}
