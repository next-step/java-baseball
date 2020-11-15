import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.NumberExtractor;

@DisplayName("숫자 추출기 클래스 테스트")
class NumberExtractorTest {

	@Test
	@DisplayName("1에서 max범위까지 숫자가 잘 나오는지 확인하는 테스트")
	void random_1부터니까_1넣으면_1나오는_테스트() {
		int one = NumberExtractor.random(1);
		assertThat(one).isEqualTo(1);
	}
}