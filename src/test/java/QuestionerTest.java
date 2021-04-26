import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuestionerTest {

	@Test
	@DisplayName(value = "3자리 숫자를 반환한다")
	void generateThreeLengthInteger() {
		Questioner questioner = new Questioner();
		String num = String.valueOf(questioner.makeProblem());
		assertThat(num.length()).isEqualTo(3);
	}

	@Test
	@DisplayName(value = "생성된 숫자는 3자리가 모두 다른 숫자이다.")
	void differentNumber() {
		Questioner questioner = new Questioner();
		String num = String.valueOf(questioner.makeProblem());

		Set<Character> count = new HashSet<>();
		for (char n : num.toCharArray()) {
			count.add(n);
		}
		assertThat(count.size()).isEqualTo(3);
	}

	@Test
	@DisplayName(value = "생성된 숫자는 0이 없다")
	void zeroIsNotExist() {
		Questioner questioner = new Questioner();
		String num = String.valueOf(questioner.makeProblem());

		assertThat(num.contains("0")).isFalse();
	}

}
