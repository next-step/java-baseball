package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumbersFactoryTest {

	@DisplayName("사이즈만큼 중복되지 않은 야구 숫자 리스트를 생성한다.")
	@ParameterizedTest
	@ValueSource(ints = { 3, 4, 5, 6 })
	void successToCreateBaseballNumbers(int size) {
		List<BaseballNumber> baseballNumbers = BaseballNumbersFactory.create(size);

		assertThat(baseballNumbers).hasSize(size);

		for (int i = 0; i < size; i++) {
			assertThat(baseballNumbers.get(i)).isInstanceOf(BaseballNumber.class);

			for (int j = i + 1; j < size; j++) {
				assertThat(baseballNumbers.get(i)).isNotEqualTo(baseballNumbers.get(j));
			}
		}
	}

}
