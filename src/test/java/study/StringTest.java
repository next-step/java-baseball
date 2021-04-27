package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
	@Test
	@DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	void splitTest() {
		// given
		String actual = "1,2";

		// when
		String[] splitString = actual.split(",");

		// then
		assertThat(splitString).containsExactly("1", "2");
	}

	@Test
	@DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다")
	void splitTest2() {
		// given
		String actual = "1";

		// when
		String[] splitString = actual.split(",");

		// then
		assertThat(splitString).containsExactly("1");
	}
}
