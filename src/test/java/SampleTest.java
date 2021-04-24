import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SampleTest {
	@Test
	void isTrue() {
		assertThat(true).isTrue();
	}

	@Test
	void isFalse() {
		assertThat(false).isFalse();
	}
}
