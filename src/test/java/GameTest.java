
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
	private final Game game = new Game();

	@Test
	@DisplayName("컴퓨터가 생성한 타겟 숫자의 유효성 체크 (size : 3, range: 1-9)")
	void generateTargetNumberTest() {
		for (int i = 0; i < 100; i++) {
			Set<Integer> numbers = game.getTargetNumberSet();
			assertThat(numbers.size()).isEqualTo(3);
			assertThat(numbers.contains(0)).isFalse();
			assertThat(numbers.contains(10)).isFalse();
		}	
	}
}