package study;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import baseball.BaseballGame;

public class BaseballTest {

	private BaseballGame baseballGame = new BaseballGame();
	
	@Test
	public void generate_random_list_test() {
		List<Integer> list = BaseballGame.generateRandomIntegerList(3);
		List<Integer> list2 = BaseballGame.generateRandomIntegerList(3);
		
		assertThat(list)
			.isEqualTo(list2);
	}
}
