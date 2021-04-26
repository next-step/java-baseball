import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
	Computer computer = new Computer();

	@Test
	@DisplayName("컴퓨터 플레이어 3자리 수 생성 테스트"
			+ "- 3자리 수 생성 확인"
			+ "- 서로 다른 수 확인")
	public void generateComputerPlayerTest() {
		List<Integer> numbers = computer.getComputerNumbers();

		assertThat(numbers)
				.isNotEmpty()
				.hasSize(3)
				.doesNotContainNull()
				.containsOnly(numbers.get(0), numbers.get(1), numbers.get(2));
	}
}
