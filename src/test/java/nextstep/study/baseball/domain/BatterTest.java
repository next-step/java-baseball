package nextstep.study.baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.study.baseball.util.BaseballUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("타자 테스트")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class BatterTest {

	@Test
	@DisplayName("1~9까지 랜덤숫자 생성하고 중복문자 있는지 확인하기")
	void testGenerateRandomNumbers() {
		// Given
		int length = 9; //1~9까지 9자리 생성
		Batter batter = new Batter();

		// When
		batter.generateRandomNumbers(length);
		List<Integer> numbers = batter.getNumbers();
		List<String> stringList = BaseballUtil.convertIntListToStringList(numbers);
		String strNum = String.join("", stringList);
		String strRemovedDupChar = BaseballUtil.removeDuplicateChar(strNum);

		// Then
		assertThat(strNum).isEqualTo(strRemovedDupChar);
	}

}
