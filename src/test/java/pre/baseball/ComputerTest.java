package pre.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer;

    public ComputerTest() {
	this.computer = new Computer();
    }

    @Test
    void 정답() {
	// given
	int[] numbers = computer.getAnswer();

	// when
	boolean result = computer.check(numbers);

	// then
	assertThat(result).isTrue();
    }

    @Test
    void 오답() {
	// given
	int[] numbers = { 1, 3, 5 };

	// when
	boolean result = computer.check(numbers);

	// then
	assertThat(result).isFalse();
    }

    @Test
    @DisplayName("숫자 검사 후 스트라이크와 볼 카운트는 0으로 초기화된다")
    void 오답_카운트리셋() {
	// given
	int[] numbers = { 1, 3, 5 };
	computer.check(numbers);

	// when
	int strikeCount = computer.getStrike();
	int ballCount = computer.getBall();

	// then
	assertThat(strikeCount).isEqualTo(0);
	assertThat(ballCount).isEqualTo(0);
    }

}
