package core;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Description : Input str -> Integer [] 변환 test class
 *
 * Created by jychoi on 2021/04/26.
 */
class InputUtilsTest {

	InputUtils inputUtils = new InputUtils();

	@BeforeEach
	void setUp() {
	}

	@Test
	@DisplayName("input str -> Integer[] 정상 입력 케이스")
	void parseInput() {

		String given = "123";
		Integer[] when = inputUtils.parseInput(given, 3);
		Integer[] then = new Integer[] {1, 2, 3};
		assertThat(when).isEqualTo(then);
	}

	@Test
	@DisplayName("input str -> Integer[] 정상 입력 케이스")
	void parseInput2() {

		String given = "654";
		Integer[] when = inputUtils.parseInput(given, 3);
		Integer[] then = new Integer[] {4, 5, 6};
		assertThat(when).isEqualTo(then);
	}

	@Test
	@DisplayName("input에 [1-9]숫자 외의 문자 들어가서 지정된 자리 수 넘어갔을 경우 iae")
	void parseInputThrowException() {

		String given = "d123";
		assertThrows(IllegalArgumentException.class, () -> inputUtils.parseInput(given, 3));
	}

	@Test
	@DisplayName("input에 [1-9]숫자 외의 문자 들어간 경우 iae")
	void parseInputThrowException2() {

		String given = "023";
		assertThrows(IllegalArgumentException.class, () -> inputUtils.parseInput(given, 3));
	}

	@Test
	@DisplayName("input에 중복 문자 들어간 경우 iae")
	void parseInputThrowException3() {

		String given = "122";
		assertThrows(IllegalArgumentException.class, () -> inputUtils.parseInput(given, 3));
	}
}
