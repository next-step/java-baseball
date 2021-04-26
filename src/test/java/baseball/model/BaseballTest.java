package baseball.model;

import static baseball.model.Baseball.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballTest {

	private Baseball baseball;

	@BeforeEach
	public void setUp() {
		baseball = new Baseball();
	}

	@Test
	public void init_WhenCalled_ShouldSetAnswer() {
		baseball.init();
		assertThat(baseball.getAnswer()).hasSize(ANSWER_SIZE);
	}
}