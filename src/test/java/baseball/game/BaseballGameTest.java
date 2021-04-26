package baseball.game;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

	@Test
	@DisplayName("3자리만큼 숫자를 생성한다.")
	void generateNumSizeTest() throws NoSuchFieldException, IllegalAccessException {
		BaseballGame baseballGame = new BaseballGame();
		Field field = baseballGame.getClass().getDeclaredField("pitcherNum");
		field.setAccessible(true);
		String pitcherNum = (String)field.get(baseballGame);
		assertThat(pitcherNum.length()).isEqualTo(3);
	}

	@Test
	@DisplayName("생성된 숫자는 중복을 포함하지 않는다.")
	void generateNumNotDuplicate() throws NoSuchFieldException, IllegalAccessException {
		BaseballGame baseballGame = new BaseballGame();
		Field field = baseballGame.getClass().getDeclaredField("pitcherNum");
		field.setAccessible(true);
		String pitcherNum = (String)field.get(baseballGame);
		List<String> myList = new ArrayList<>(Arrays.asList(pitcherNum.split("")));

		assertThat(Collections.frequency(myList, myList.get(0))).isOne();
		assertThat(Collections.frequency(myList, myList.get(1))).isOne();
		assertThat(Collections.frequency(myList, myList.get(2))).isOne();
	}

	@Test
	@DisplayName("생성된 숫자는 1부터 9까지의 수이다.")
	void generateNumOneToNine() throws NoSuchFieldException, IllegalAccessException {
		BaseballGame baseballGame = new BaseballGame();
		Field field = baseballGame.getClass().getDeclaredField("pitcherNum");
		field.setAccessible(true);
		String pitcherNum = (String)field.get(baseballGame);

		for (char ch : pitcherNum.toCharArray()) {
			assertThat(Character.getNumericValue(ch)).isGreaterThan(0);
			assertThat(Character.getNumericValue(ch)).isLessThan(10);
		}
	}
}