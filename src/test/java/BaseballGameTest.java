import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
	private BaseballGame baseballGame = new BaseballGame();

	@Test
	@DisplayName("초기화된 문제의 숫자가 3개")
	public void initialize_rightAnswer_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException,
		NoSuchFieldException {

		//given
		final int ANSWER_LENGTH = 3;
		baseballGame.play();
		Field field = baseballGame.getClass().getDeclaredField("rightAnswer");
		field.setAccessible(true);

		//when
		List<Integer> rightAnswer = (List<Integer>)field.get(baseballGame);

		//then
		assertThat(rightAnswer).hasSize(ANSWER_LENGTH);
	}

	@Test
	@DisplayName("랜덤으로 생성된 숫자가 0~9 사이")
	public void getRandomNumber_return_from_zero_to_nine_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		//given
		Method method = baseballGame.getClass().getDeclaredMethod("getRandomNumber");
		method.setAccessible(true);

		//when
		int randomNumber = (int)method.invoke(baseballGame);

		//then
		assertThat(randomNumber).isGreaterThanOrEqualTo(0)
			.isLessThanOrEqualTo(9);
	}
}
