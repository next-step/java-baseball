package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class NextStepInputConverterTest {

	@Test
	void convert() {
		assertThat(NextStepInputConverter.convert("1")).isEqualTo(NextStepType.RESTART);
		assertThat(NextStepInputConverter.convert("2")).isEqualTo(NextStepType.EXIT);
	}

	@Test
	void convert_exception() {
		assertThatThrownBy(() -> NextStepInputConverter.convert(null))
			.isInstanceOf(WrongNextStepInputException.class);
		assertThatThrownBy(() -> NextStepInputConverter.convert("unknown"))
			.isInstanceOf(WrongNextStepInputException.class);
	}
}