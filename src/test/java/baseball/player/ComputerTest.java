package baseball.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터의 수")
class ComputerTest {

	@DisplayName("[성공] 생성")
	@RepeatedTest(10)
	public void success_create() {
		// given
		int size = 3;

		// when
		Computer computer = Computer.of(size);

		// then
		List<Integer> numbers = computer.getNumberList();
		assertThat(numbers.size()).isEqualTo(size);
		assertThat(!numbers.get(0).equals(numbers.get(1))
			&& !numbers.get(1).equals(numbers.get(2))).isTrue();

		System.out.printf("### %d, %d, %d%n", numbers.get(0), numbers.get(1), numbers.get(2));
	}

	@DisplayName("[성공] 초기화")
	@RepeatedTest(10)
	public void success_reset() {
		// given
		int size = 3;
		Computer computer = Computer.of(size);
		List<Integer> beforeNumbers = computer.getNumberList();

		// when
		computer.reset();

		// then
		List<Integer> afterNumbers = computer.getNumberList();
		assertThat(beforeNumbers.equals(afterNumbers)).isFalse();

		System.out.printf("### beforeNumbers: %d, %d, %d%n", beforeNumbers.get(0), beforeNumbers.get(1), beforeNumbers.get(2));
		System.out.printf("### afterNumbers: %d, %d, %d%n", afterNumbers.get(0), afterNumbers.get(1), afterNumbers.get(2));
	}
}
