package jbh.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallUtilTest {

	@RepeatedTest(value = 20)
	@DisplayName("랜덤한_3자리숫자_생성_검증_테스트 - 중복값, 값 범위 검증")
	public void makeRandomTextTest() {
		String randomText = BallUtil.makeBall(3);
		Set<Character> resultSet = new HashSet<>();
		boolean rangeCheck = true;
		for (char c : randomText.toCharArray()) {
			resultSet.add(c);
			rangeCheck &= '1' <= c && '9' >= c;
		}
		assertThat(resultSet.size()).isEqualTo(3);
		assertThat(rangeCheck).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"3:123:true", "3:195:false", "9:126:false", "8:987:true", "1:123:true"}, delimiter = ':')
	@DisplayName("문자열_내_캐릭터문자_존재_여부_검증_테스트")
	public void containCharacterInStringTextTest(char numberChar, String numbersText, boolean exists) {
		boolean result = BallUtil.containCharInText(numberChar, numbersText);
		assertThat(result).isEqualTo(exists);
	}
}
