package nextstep.kht2199.precourse;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class FBGameNumberTest {

	FBGameNumber number = new FBGameNumber();

	@RepeatedTest(10)
	@DisplayName("중복되지 않은 3자리 숫자를 생성")
	void generateNumber() {
		String s = String.valueOf(number.generateNumber());
		Set<Character> charSet = new HashSet<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			charSet.add(aChar);
		}
		assertThat(charSet.size())
			.isEqualTo(3)
		;
	}
}