package baseball.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

	@Test
	@DisplayName("서로 다른 임의의 숫자 3개 생성 테스트")
	public void createComputer() {
		Computer computer = new Computer();

		List<Integer> baseball = computer.getBaseball();
		assertThat(baseball.size()).isEqualTo(3);
	}
}
