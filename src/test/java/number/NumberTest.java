package number;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

	@Test
	@DisplayName("값이 같은 Number 는 동일하다")
	public void equalTest() {
		Number one = Number.of(1);
		Number another = Number.of(1);

		assertThat(one).isEqualTo(another);
	}

	@Test
	@DisplayName("값이 다른 Number 는 동일하다")
	public void notEqualTest() {
		Number one = Number.of(1);
		Number another = Number.of(2);

		assertThat(one).isNotEqualTo(another);
	}

}
