import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@DisplayName("상대방의 숫자와 게임플레이어가 제시한 숫자에 따라 스트라이트와 볼의 확인 테스트")
	@ParameterizedTest(name = "{index} - 상대방 숫자:{0} 게임 플레이어 숫자:{1} --> {2} 스트라이크 {3} 볼")
	@CsvSource(value = {"123:145:1:0", "123:125:2:0", "123:123:3:0", "123:415:0:1", "123:512:0:2", "123:312:0:3",
		"123:135:1:1", "123:132:1:2", "123:456:0:0"}, delimiter = ':')
	public void calcStrikeBallCountTest(int enemyNum, int humanNum, int expectedStrikeCnt, int expectedBallCnt) throws
		NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

		// given
		Field fieldEnemyNum = game.getClass().getDeclaredField("enemyNum");
		fieldEnemyNum.setAccessible(true);
		fieldEnemyNum.set(game, enemyNum);

		Field fieldHumanNum = game.getClass().getDeclaredField("humanNum");
		fieldHumanNum.setAccessible(true);
		fieldHumanNum.set(game, humanNum);

		// when
		Method method = game.getClass().getDeclaredMethod("calcStrikeBallCount");
		method.setAccessible(true);
		method.invoke(game);

		// then
		Field fieldStrikeCnt = game.getClass().getDeclaredField("strikeCnt");
		fieldStrikeCnt.setAccessible(true);
		assertThat(fieldStrikeCnt.get(game)).isEqualTo(expectedStrikeCnt);

		Field fieldBallCnt = game.getClass().getDeclaredField("ballCnt");
		fieldBallCnt.setAccessible(true);
		assertThat(fieldBallCnt.get(game)).isEqualTo(expectedBallCnt);
	}

	@DisplayName("3 스트라이크 여부 기능 정상작동 테스트")
	@ParameterizedTest(name = "{index} - {0} 스트라이크 {1} 볼 --> {2}")
	@CsvSource(value = {"1:0:false", "2:0:false", "3:0:true", "0:1:false", "0:2:false", "0:3:false", "1:1:false",
		"1:2:false", "0:0:false"}, delimiter = ':')
	public void isThreeStrikeTest(int strikeCnt, int ballCnt, boolean expected) throws
		NoSuchFieldException,
		IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		// given
		Field fieldStrikeCnt = game.getClass().getDeclaredField("strikeCnt");
		fieldStrikeCnt.setAccessible(true);
		fieldStrikeCnt.set(game, strikeCnt);

		Field fieldBallCnt = game.getClass().getDeclaredField("ballCnt");
		fieldBallCnt.setAccessible(true);
		fieldBallCnt.set(game, ballCnt);

		// when
		Method method = game.getClass().getDeclaredMethod("isThreeStrike");
		method.setAccessible(true);

		// then
		assertThat(method.invoke(game)).isEqualTo(expected);
	}
}
