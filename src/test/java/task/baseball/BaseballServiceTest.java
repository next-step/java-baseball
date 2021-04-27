package task.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

	BaseballService baseballService;

	@BeforeEach
	void setup() {
		this.baseballService = new BaseballService();
	}

	@Test
	@DisplayName("0-9 랜덤 3자리, 중복 없는 answer 생성")
	void generateRandomAnswer() {
		List<Integer> randomAnswer = baseballService.generateRandomAnswer();

		assertThat(randomAnswer).hasSize(3).doesNotHaveDuplicates();
	}

	@Test
	@DisplayName("Strike 판별, 같은 위치/숫자 개수")
	void getStrikeCount() {
		List<Integer> answer = Arrays.asList(1, 2, 3);

		assertThat(baseballService.getStrikeCount(new int[] {1, 2, 3}, answer)).isEqualTo(3);
		assertThat(baseballService.getStrikeCount(new int[] {1, 2, 5}, answer)).isEqualTo(2);
		assertThat(baseballService.getStrikeCount(new int[] {1, 5, 6}, answer)).isEqualTo(1);
		assertThat(baseballService.getStrikeCount(new int[] {5, 6, 7}, answer)).isEqualTo(0);
	}

	@Test
	@DisplayName("answer 과 일치 판별, 스트라이크 개수가 3일 경우에만 true")
	void isAnswer() {
		assertThat(baseballService.isAnswer(3)).isTrue();

		assertThat(baseballService.isAnswer(2)).isFalse();
		assertThat(baseballService.isAnswer(1)).isFalse();
		assertThat(baseballService.isAnswer(0)).isFalse();
		assertThat(baseballService.isAnswer(4)).isFalse();
	}

	@Test
	@DisplayName("Ball 판별, 다른 위치에 숫자가 포함되어 있는 개수")
	void getBallCount() {
		List<Integer> answer = Arrays.asList(1, 2, 3);

		assertThat(baseballService.getBallCount(new int[] {1, 2, 3}, answer)).isEqualTo(0);
		assertThat(baseballService.getBallCount(new int[] {5, 6, 1}, answer)).isEqualTo(1);
		assertThat(baseballService.getBallCount(new int[] {2, 3, 5}, answer)).isEqualTo(2);
		assertThat(baseballService.getBallCount(new int[] {3, 1, 2}, answer)).isEqualTo(3);
	}

	@Test
	@DisplayName("NotThing 판별, strike/ball 개수가 둘다 0 일 경우 true, 그 외 false")
	void isNotThing() {
		assertThat(baseballService.isNotThing(0, 0)).isTrue();

		assertThat(baseballService.isNotThing(1, 0)).isFalse();
		assertThat(baseballService.isNotThing(0, 1)).isFalse();
	}

	@Test
	@DisplayName("출력 메시지 생성, ")
	void generateOutputMessage() {
		assertThat(baseballService.generateOutputMessage(1, 1)).isEqualTo("1스트라이크 1볼");
		assertThat(baseballService.generateOutputMessage(0, 1)).isEqualTo("1볼");
		assertThat(baseballService.generateOutputMessage(2, 0)).isEqualTo("2스트라이크");
	}

	@Test
	@DisplayName("출력 메시지 생성, 정답 일 경우")
	void generateAnswerOutputMessage() {
		assertThat(baseballService.generateAnswerOutputMessage()).isEqualTo("3스트라이크\n3개의숫자를모두맞히셨습니다!게임종료");
	}

	@Test
	@DisplayName("출력 메시지 생성, nothing 일 경우")
	void generateNotThingOutputMessage() {
		assertThat(baseballService.generateNotThingOutputMessage()).isEqualTo("낫싱");
	}

	@Test
	@DisplayName("입력 데이터 검증 및 int to int[] 변경")
	void validateInputAndConvert() {
		assertThat(baseballService.validateInputAndConvert("123")).hasSize(3).containsExactly(1, 2, 3);
	}

	@Test
	@DisplayName("입력 데이터 검증, 입력의 자리수가 3이 아닐 경우")
	void validateInputAndConvert_failure() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				baseballService.validateInputAndConvert("1234");
			})
			.withMessage("잘못된 포맷 : 입력값은 3자리수 입니다.");

		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				baseballService.validateInputAndConvert("14");
			})
			.withMessage("잘못된 포맷 : 입력값은 3자리수 입니다.");
	}

	@Test
	@DisplayName("입력 데이터 검증, 입력값에 숫자가 아닌 값이 포함되어 있는 경우")
	void validateInputAndConvert_failure2() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				baseballService.validateInputAndConvert("12a");
			})
			.withMessage("잘못된 포맷 : 입력값은 숫자만 가능합니다.");
	}

	@Test
	@DisplayName("입력 데이터 검증, 입력값에 중복된 숫자가 포함되어 있는 경우")
	void validateInputAndConvert_failure3() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> baseballService.validateInputAndConvert("122"))
			.withMessage("잘못된 포맷 : 입력값은 서로 중복되지 않아야 합니다.");
	}
}
