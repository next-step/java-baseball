import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import constant.BaseballGameCondition;

public class NumberGeneratorTest {

	private NumberGenerator numberGenerator;

	@BeforeEach
	void setup() {
		this.numberGenerator = new NumberGenerator();
	}

	@Test
	@DisplayName("숫자 야구 생성 테스트 - 생성  자리 수 ")
	void testGenerateNumberSize() {
		List<Integer>  baseballNumbers = this.numberGenerator.generateBaseballNumbers().getNumbers();
		assertThat(baseballNumbers).hasSize(BaseballGameCondition.BALL_NUMBER_LENGTH);
	}

	@Test
	@DisplayName("숫자 야구 생성 테스트 - 생성된 숫자 구간")
	void testGenerateNumbersInterval() {
		List<Integer>  baseballNumbers = this.numberGenerator.generateBaseballNumbers().getNumbers();
		for(int baseballNumber : baseballNumbers) {
			assertThat(baseballNumber).isGreaterThanOrEqualTo(BaseballGameCondition.GENERATE_NUMBER_MIN)
				.isLessThan(BaseballGameCondition.GENERATE_NUMBER_MIN + BaseballGameCondition.GENERATE_NUMBER_LENGTH);
		}
	}

	@Test
	@DisplayName("숫자 야구 생성 테스트 - 중복 숫자 없음")
	void testGenerateNumbersDuplication() {
		List<Integer>  baseballNumbers = this.numberGenerator.generateBaseballNumbers().getNumbers();
		Set<Integer> numberSet = new HashSet<>(baseballNumbers);
		assertThat(baseballNumbers).hasSize(numberSet.size());
		numberSet.add(2);
	}
}
