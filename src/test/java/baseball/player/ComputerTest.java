package baseball.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 12:59 AM
 */

class ComputerTest {
	@Test
	@DisplayName("컴퓨터볼 숫자가 유효범위에 포함되는지 확인")
	void validComputerSelectBalls() {
		Computer computer = new Computer();
		// 50회 정도 반복해서 모두 유효범위에 있는지 확인한다. (1 ~ 9)
		for (int i = 0; i < 50; ++i) {
			int[] balls = computer.selectComputerBalls(3);
			for (int ball : balls) {
				Assertions.assertThat(ball).isBetween(1, 9);
			}
		}
	}
}
