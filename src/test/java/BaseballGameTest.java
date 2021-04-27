import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
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

	@Test
	@DisplayName("0-9 사이의 서로 다른 3개의 수인지 확인하는 areThreeNumbersFromZeroToNine 메소드에 "
		+ "'123'을 입력했을 때 true 반환")
	public void areThreeNumbersFromZeroToNine_input123_returnTrue_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		//given
		Method method = baseballGame.getClass().getDeclaredMethod("areThreeNumbersFromZeroToNine", String.class);
		method.setAccessible(true);

		//when
		boolean flag = (boolean)method.invoke(baseballGame, "123");

		//then
		assertThat(flag).isTrue();
	}

	@Test
	@DisplayName("0-9 사이의 서로 다른 3개의 수인지 확인하는 areThreeNumbersFromZeroToNine 메소드에 "
		+ "'113'을 입력했을 때 false 반환")
	public void areThreeNumbersFromZeroToNine_input113_returnFalse_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		//given
		Method method = baseballGame.getClass().getDeclaredMethod("areThreeNumbersFromZeroToNine", String.class);
		method.setAccessible(true);

		//when
		boolean flag = (boolean)method.invoke(baseballGame, "113");

		//then
		assertThat(flag).isFalse();
	}

	@Test
	@DisplayName("0-9 사이의 서로 다른 3개의 수인지 확인하는 areThreeNumbersFromZeroToNine 메소드에 "
		+ "'string'을 입력했을 때 false 반환")
	public void areThreeNumbersFromZeroToNine_inputString_returnFalse_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		//given
		Method method = baseballGame.getClass().getDeclaredMethod("areThreeNumbersFromZeroToNine", String.class);
		method.setAccessible(true);

		//when
		boolean flag = (boolean)method.invoke(baseballGame, "string");

		//then
		assertThat(flag).isFalse();
	}

	@Test
	@DisplayName("stringToIntegers 메소드에 '123' 입력시 arrayList 반환")
	public void stringToIntegers_input123_returnArrayList_Test()throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		final List<Integer> EXPECTED_LIST = Arrays.asList(1, 2, 3);

		//given
		Method method = baseballGame.getClass().getDeclaredMethod("stringToIntegers", String.class);
		method.setAccessible(true);

		//when
		List<Integer> integers = (List<Integer>)method.invoke(baseballGame, "123");

		//then
		assertThat(integers).isEqualTo(EXPECTED_LIST);
	}
}
