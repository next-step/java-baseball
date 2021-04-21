package nextstep.study.baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("타자 테스트")
public class BatterTest {

	@Test
	@DisplayName("랜덤숫자 3개 생성하고 확인하기")
	void generateRandomNumbers_checkLength() {
		Batter batter = new Batter();
		List<Integer> numbers = batter.generateRandomNumbers(3);

		//3자리 확인
		assertThat(numbers.size()).isEqualTo(3);

		//숫자가 범위안에 있는지
		for (Integer number : numbers) {
			assertThat(number).isBetween(1, 9);
		}

	}

}
