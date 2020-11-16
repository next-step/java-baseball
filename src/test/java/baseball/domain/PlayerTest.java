package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	@DisplayName("player 숫자 입력 생성 테스트")
	public void createPlayer() {
		String input = "234";
		Player player = new Player();
		player.inputBaseBall(input);

        List<Integer> baseball = player.inputBaseBall(input);
        assertThat(baseball.size()).isEqualTo(3);
	}
}
