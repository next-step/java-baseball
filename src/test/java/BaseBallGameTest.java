import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {
	BaseBallGame baseBallGame;

	@BeforeEach
	void setUp() {
		baseBallGame = new BaseBallGame();
	}

	@Test
	public void makeNumberTest() {
		LinkedHashSet<String> numbers = baseBallGame.makeNumbers();
		assertThat(numbers.size() == 3).isTrue();

		for(String number : numbers){
			assertTrue(number.matches("[1-9]"));
			System.out.println(number);
		}
	}

	@Test
	public void callStrikeTest() {
		assertThat(baseBallGame.callStrike("123", "123") == 3).isTrue();
		assertThat(baseBallGame.callStrike("124","125") == 2).isTrue();
		assertThat(baseBallGame.callStrike("111", "112") == 3).isFalse();
	}

	@Test
	public void compareNumberTest(){
		assertThat(baseBallGame.compareStrike('1','2') == 0).isTrue();
		assertThat(baseBallGame.compareStrike('1','1') == 1).isTrue();
	}

	@Test
	public void callBallTest() {
		assertThat(baseBallGame.callBall("123", "231") == 3).isTrue();
		assertThat(baseBallGame.callBall("124", "421") == 2).isTrue();
		assertThat(baseBallGame.callBall("125", "125") == 0).isTrue();
	}

	@Test
	public void compareBallTest(){
		assertThat(baseBallGame.compareBall('1', "123", 0) == 0).isTrue();
		assertThat(baseBallGame.compareBall('2', "123", 0) == 1).isTrue();
	}

	@Test
	public void makeGameResultTest(){
		assertEquals("낫싱", baseBallGame.makeGameResult(0, 0));
		assertEquals("1 스트라이크 ", baseBallGame.makeGameResult(1, 0));
		assertEquals("1 스트라이크 2 볼 ", baseBallGame.makeGameResult(1, 2));
	}
}
