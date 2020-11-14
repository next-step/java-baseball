import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
		Score score = computer.calculateScore("123");
		assertThat(score.isAllStrike()).isTrue();
		assertThat(score.getScoreString()).isEqualTo("3 스트라이크");
	}
}