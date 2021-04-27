import baseBall.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@DisplayName("유저가 입력한 여러 숫자 매칭 테스트(스트라이크)")
	@ParameterizedTest(name = "[{0}, {1}, {2}] is {3} strike")
	@CsvSource({"1,2,3,0", "4,2,8,1", "3,8,7,1", "4,2,6,2", "4,8,1,2", "4,8,6,3"})
	public void 스트라이크_매칭_결과_테스트(int num1, int num2, int num3, int expected) {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(num1);
		userNumber.add(num2);
		userNumber.add(num3);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isEqualTo(expected);
	}

	@DisplayName("유저가 입력한 여러 숫자 매칭 테스트(볼)")
	@ParameterizedTest(name = "[{0}, {1}, {2}] is {3} ball")
	@CsvSource({"8,6,4,3", "4,2,8,1", "4,8,6,0", "7,6,8,2", "8,6,7,2", "2,4,8,2"})
	public void 볼_매칭_결과_테스트(int num1, int num2, int num3, int expected) {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(num1);
		userNumber.add(num2);
		userNumber.add(num3);

		computer.matchResult(userNumber);

		assertThat(computer.getBallCount()).isEqualTo(expected);
	}

	@DisplayName("유저가 입력한 여러 숫자 매칭 테스트(낫싱)")
	@ParameterizedTest(name = "[{0}, {1}, {2}] is nothing")
	@CsvSource({"7,5,9", "1,2,3", "9,5,1", "2,3,5", "9,1,3", "3,9,5"})
	public void 낫싱_매칭_결과_테스트(int num1, int num2, int num3) {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(num1);
		userNumber.add(num2);
		userNumber.add(num3);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isZero();
		assertThat(computer.getBallCount()).isZero();
	}
}
