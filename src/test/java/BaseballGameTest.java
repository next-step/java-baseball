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
	public void stringToIntegers_input123_returnArrayList_Test() throws
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

	@Test
	@DisplayName("isCorrectAnswer에 요소가 같은 List 입력했을 때 true 반환")
	public void isCorrectAnswer_inputSameList_returnTrue_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		final List<Integer> LIST_A = Arrays.asList(1, 2, 3);
		final List<Integer> LIST_B = Arrays.asList(1, 2, 3);

		//given
		Method method = baseballGame.getClass().getDeclaredMethod("isCorrectAnswer", List.class, List.class);
		method.setAccessible(true);

		//when
		boolean flag = (boolean)method.invoke(baseballGame, LIST_A, LIST_B);

		//then
		assertThat(flag).isTrue();
	}

	@Test
	@DisplayName("isCorrectAnswer 메소드에 요소가 다른 List 입력했을 때 false 반환")
	public void isCorrectAnswer_inputDifferentList_returnFalse_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		final List<Integer> LIST_A = Arrays.asList(1, 2, 3);
		final List<Integer> LIST_B = Arrays.asList(2, 3, 4);

		//given
		Method method = baseballGame.getClass().getDeclaredMethod("isCorrectAnswer", List.class, List.class);
		method.setAccessible(true);

		//when
		boolean flag = (boolean)method.invoke(baseballGame, LIST_A, LIST_B);

		//then
		assertThat(flag).isFalse();
	}

	@Test
	@DisplayName("containValueAndNotSameIndex 메소드에서 리스트에 포함된 요소지만 같은 인덱스를 가지면 0 반환")
	public void containValueAndNotSameIndex_inputConatinValueButSameIndex_return0_Test() throws
		NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		final List<Integer> LIST = Arrays.asList(1, 2, 3);
		final Integer VALUE = 1;
		final Integer IDX = 0;

		//given
		Method method = baseballGame.getClass().
			getDeclaredMethod("containValueAndNotSameIndex", List.class, Integer.class, int.class);
		method.setAccessible(true);

		//when
		int num = (int)method.invoke(baseballGame, LIST, VALUE, IDX);

		//then
		assertThat(num).isSameAs(0);
	}

	@Test
	@DisplayName("containValueAndNotSameIndex 메소드에서 리스트에 포함된 요소가 아니면 0 반환")
	public void containValueAndNotSameIndex_inputNotContainValue_return0_Test() throws
		NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		final List<Integer> LIST = Arrays.asList(1, 2, 3);
		final Integer VALUE = 4;
		final Integer IDX = 0;

		//given
		Method method = baseballGame.getClass().
			getDeclaredMethod("containValueAndNotSameIndex", List.class, Integer.class, int.class);
		method.setAccessible(true);

		//when
		int num = (int)method.invoke(baseballGame, LIST, VALUE, IDX);

		//then
		assertThat(num).isSameAs(0);
	}

	@Test
	@DisplayName("containValueAndNotSameIndex 메소드에서 리스트에 포함된 요소이고 다른 인덱스를 가지면 1 반환")
	public void containValueAndNotSameIndex_inputConatinValueAndOtherIndex_return1_Test() throws
		NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		final List<Integer> LIST = Arrays.asList(1, 2, 3);
		final Integer VALUE = 1;
		final Integer IDX = 2;

		//given
		Method method = baseballGame.getClass().
			getDeclaredMethod("containValueAndNotSameIndex", List.class, Integer.class, int.class);
		method.setAccessible(true);

		//when
		int num = (int)method.invoke(baseballGame, LIST, VALUE, IDX);

		//then
		assertThat(num).isSameAs(1);
	}

}
