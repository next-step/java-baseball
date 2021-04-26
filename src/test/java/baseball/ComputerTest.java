package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	List<Integer> computerBalls = new ArrayList<>();

	@BeforeEach
	void init() {
		computerBalls.add(1);
		computerBalls.add(2);
		computerBalls.add(3);
	}

	@DisplayName("3 스트라이크 계산하기")
	@Test
	void calc_score() {
		// given
		Computer computer = new Computer(computerBalls);

		List<Integer> userInputNum = new ArrayList<>();
		userInputNum.add(1); // 스트라이크
		userInputNum.add(2); // 스트라이크
		userInputNum.add(3); // 스트라이크

		// when
		computer.calcScore(userInputNum);

		// then
		assertThat(computer.getStrike()).isEqualTo(3);
		assertThat(computer.getBall()).isZero();
	}

	@DisplayName("포볼 계산하기")
	@Test
	void four_ball() {
		// given
		Computer computer = new Computer(computerBalls);

		List<Integer> userInputNum = new ArrayList<>();
		userInputNum.add(4); // 볼
		userInputNum.add(5); // 볼
		userInputNum.add(6); // 볼

		// when
		computer.calcScore(userInputNum);

		// then
		assertThat(computer.getStrike()).isZero();
		assertThat(computer.getBall()).isZero();
	}

	@DisplayName("볼 계산하기")
	@Test
	void ball() {
		// given
		Computer computer = new Computer(computerBalls);

		List<Integer> userInputNum = new ArrayList<>();
		userInputNum.add(3); // 볼
		userInputNum.add(2); // 스트라이크
		userInputNum.add(1); // 볼

		// when
		computer.calcScore(userInputNum);

		// then
		assertThat(computer.getStrike()).isEqualTo(1);
		assertThat(computer.getBall()).isEqualTo(2);
	}

}