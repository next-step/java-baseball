package pre.baseball;

import static org.assertj.core.api.Assertions.assertThat;

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
    void 스트라이크_또는_볼_또는_낫싱() {
	// given
	int[] numbers = { 1, 3, 5 };

	// when
	boolean result = computer.check(numbers);

	// then
	assertThat(result).isFalse();
    }

}
