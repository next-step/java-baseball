package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BaseballAnswerTest {
	private final BaseballAnswer answer = new BaseballAnswer();

	@Nested
	@DisplayName("정답 숫자 생성 테스트")
	class MakeAnswerTest {

		@BeforeEach
		void setUp() {
			answer.makeAnswer();
		}

		@Test
		@Order(1)
		@DisplayName("3자리 생성되는지 확인")
		void threeNumberTest() {
			assertThat(answer.getAnswer().length).isEqualTo(3);
		}

		@ParameterizedTest
		@ValueSource(ints = {0, 1, 2})
		@Order(2)
		@DisplayName("1-9만 포함하는지 확인")
		void noZeroTest(int index) {
			assertThat(answer.getAnswer()[index]).isGreaterThanOrEqualTo('1').isLessThanOrEqualTo('9');
		}

		@Test
		@Order(3)
		@DisplayName("서로 다른 숫자인지 확인")
		void allDifferentTest() {
			assertThat(answer.getAnswer()[0]).isNotEqualTo(answer.getAnswer()[1]).isNotEqualTo(answer.getAnswer()[2]);
			assertThat(answer.getAnswer()[1]).isNotEqualTo(answer.getAnswer()[0]).isNotEqualTo(answer.getAnswer()[2]);
			assertThat(answer.getAnswer()[2]).isNotEqualTo(answer.getAnswer()[0]).isNotEqualTo(answer.getAnswer()[1]);
		}
	}

	@Nested
	@DisplayName("사용자 입력 숫자 비교 테스트 (정답: 3,2,8)")
	class CheckAnswerTest {
		@BeforeEach
		void setUp() {
			Character[] answerArray = {'3', '2', '8'};
			answer.setAnswer(answerArray);
		}

		@Test
		@Order(1)
		@DisplayName("328 정답 확인")
		void exactlyAnswerTest() {
			String answerInput = "328";
			answer.checkAnswer(answerInput.toCharArray());
			assertThat(answer.getStrikeCnt()).isEqualTo(3);
			assertThat(answer.getBallCnt()).isEqualTo(0);
			assertThat(answer.isExactlyAnswer()).isTrue();
			assertThat(answer.isNothing()).isFalse();
		}

		@Test
		@Order(2)
		@DisplayName("298 1 스트라이크 1볼 확인")
		void strikeBallText() {
			String answerInput = "298";
			answer.checkAnswer(answerInput.toCharArray());
			assertThat(answer.getStrikeCnt()).isEqualTo(1);
			assertThat(answer.getBallCnt()).isEqualTo(1);
			assertThat(answer.isExactlyAnswer()).isFalse();
			assertThat(answer.isNothing()).isFalse();
		}

		@Test
		@Order(3)
		@DisplayName("769 낫싱 확인")
		void nothingText() {
			String answerInput = "769";
			answer.checkAnswer(answerInput.toCharArray());
			assertThat(answer.getStrikeCnt()).isEqualTo(0);
			assertThat(answer.getBallCnt()).isEqualTo(0);
			assertThat(answer.isExactlyAnswer()).isFalse();
			assertThat(answer.isNothing()).isTrue();
		}
	}
}
