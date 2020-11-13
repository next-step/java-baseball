package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class NextStepTypeTest {

	@Test
	void findBy() {
		assertThat(NextStepType.findBy(1)).isEqualTo(NextStepType.RESTART);
		assertThat(NextStepType.findBy(2)).isEqualTo(NextStepType.EXIT);
	}

	@Test
	void findBy_exception() {
		assertThatThrownBy(() -> NextStepType.findBy(3))
			.isInstanceOf(WrongNextStepInputException.class);
	}

}