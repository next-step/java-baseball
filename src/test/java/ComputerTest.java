import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
	Computer computer = new Computer();

	@Test
	@DisplayName("컴퓨터 플레이어 3자리 수 생성 테스트"
			+ "- 3자리 수 생성 확인"
			+ "- 서로 다른 수 확인")
	public void generateComputerPlayerTest() {
		computer.generateNumbers();
		List<Integer> numbers = computer.getComputerNumbers();

		assertThat(numbers)
				.isNotEmpty()
				.hasSize(3)
				.doesNotContainNull()
				.containsOnly(numbers.get(0), numbers.get(1), numbers.get(2));
	}

	@Test
	@DisplayName("유저가 입력한 숫자 매칭 테스트 - 1 스트라이크")
	public void 원_스트라이크_매칭_테스트() {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(4);
		userNumber.add(6);
		userNumber.add(8);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isEqualTo(1);
	}

	@Test
	@DisplayName("유저가 입력한 숫자 매칭 테스트 - 2 스트라이크")
	public void 투_스트라이크_매칭_테스트() {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(4);
		userNumber.add(8);
		userNumber.add(7);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("유저가 입력한 숫자 매칭 테스트 - 3 스트라이크")
	public void 쓰리_스트라이크_매칭_테스트() {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(4);
		userNumber.add(8);
		userNumber.add(6);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isEqualTo(3);
	}
}
