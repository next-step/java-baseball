package jbh.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UIUtilTest {

	UIUtil util = new UIUtil();

	@ParameterizedTest
	@CsvSource(value = {"1:false", "2:false", "3:true", "4:true", "10:true", "a:true", "ab:true"}, delimiter = ':')
	public void inputTestValidationTest1(String input, boolean result) {
		assertThat(util.isWrongMenuNumber(input)).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"3:false", "4:false", "9:false", "0:true", "a:true", "x:true"}, delimiter = ':')
	public void ohasCharacterOutOfRangeTest(String input, boolean result) {
		boolean b = util.hasCharacterOutOfRange(input);
		assertThat(b).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"32:false", "41:false", "99:true", "00:true", "aa:true", "xd:false"}, delimiter = ':')
	public void hasDuplicateCharacterTest(String input, boolean result) {
		boolean b = util.hasDuplicateCharacter(input);
		assertThat(b).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:false", "456:false", "789:false", "788:true", "ab3:true", "12:true"}, delimiter = ':')
	public void inputTestValidationTest2(String input, boolean result) {
		assertThat(util.isWrongBallNumbers(input, 3)).isEqualTo(result);
	}
}
