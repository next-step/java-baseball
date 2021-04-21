package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringTest {
    @Test
    void split() {
		assertThat("1,2".split(",")).contains("1").contains("2");
		assertThat("1".split(",")).containsExactly("1");
	}
}
