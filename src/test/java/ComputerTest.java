import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.NumberExtractor;

@DisplayName("컴퓨터 클래스 테스트")
class ComputerTest {

	Computer computer = new Computer();

	@BeforeEach
	void init() {
		computer.initNumbersForTest(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("점수 계산 테스트")
	void calculateScore() {
		Score score = computer.calculateScore(Arrays.asList(1,2,3));
		assertThat(score.isAllStrike()).isTrue();
		assertThat(score.calculateScore()).isEqualTo("3 스트라이크");
	}
}