package study;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.BaseballGame;

public class BaseballTest {

	private BaseballGame baseballGame = new BaseballGame();
	private List<Integer> inputListValue;
	private List<Integer> randomListValue;
	
	@BeforeEach
	public void init() {
		inputListValue = BaseballGame.generateRandomIntegerList(3);
		randomListValue = BaseballGame.generateRandomIntegerList(3);
	}
	
	@Test
	@DisplayName("임의의 숫자 생성 기능 테스트")
	public void generate_random_list_test() {
		assertThat(inputListValue).isNotEqualTo(randomListValue);
	}
}
