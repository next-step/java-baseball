import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
	private Game game;

	@BeforeEach
	public void setUp() {
		game = new Game();
	}

	@Test
	@DisplayName("상대방의 숫자가 1 ~ 9 사이의 서로 다른 임의의 수 3개를 선택 확인 테스트")
	public void createEnemyNumTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = game.getClass().getDeclaredMethod("createEnemyNum");
		method.setAccessible(true);

		// when
		int enemyNum = (int)method.invoke(game);
		int[] count = new int[10];
		for (int i = 100; i >= 1; i /= 10) {
			count[(int)enemyNum / i]++;
			enemyNum %= i;
		}

		// then
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			assertThat(count[i]).isLessThanOrEqualTo(1);
			sum += count[i];
		}
		assertThat(sum).isEqualTo(3);
	}
}
