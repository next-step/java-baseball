import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInterfaceTest {
	private UserInterface userInterface = new UserInterface();

	// Test Method Name Rule : MethodName_StateUnderTest_ExpectedBehavior

	@Test
	@DisplayName("continueOrStop 메소드 인자로 1 입력했을 때 true 반환")
	public void continueOrStop_inputIsOne_returnTrue_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		//given

		//when
		boolean flag = continueOrStop(1);

		//then
		assertThat(flag).isTrue();
	}

	@Test
	@DisplayName("continueOrStop 메소드 인자로 2 입력했을 때 false 반환")
	public void continueOrStop_inputIsTwo_returnFalse_Test() throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {

		//given

		//when
		boolean returnValue = continueOrStop(2);

		//then
		assertThat(returnValue).isFalse();
	}

	private boolean continueOrStop(int input) throws
		NoSuchMethodException,
		IllegalAccessException,
		InvocationTargetException {

		Method method = userInterface.getClass().getDeclaredMethod("continueOrStop", int.class);
		method.setAccessible(true);
		return (boolean)method.invoke(userInterface, input);

	}

	@DisplayName("isOneOrTwo 메소드 인자로 1(String) 또는 2(String) 입력했을 때 true 반환")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	public void isOneOrTwo_inputOneOrTwo_returnTrue_Test(String arg) throws
		NoSuchMethodException,
		IllegalAccessException,
		InvocationTargetException {

		//given

		//when
		boolean returnValue = isOneOrTwo(arg);

		//then
		assertThat(returnValue).isTrue();
	}

	@DisplayName("isOneOrTwo 메소드 인자로 1234(String) 또는 'string' 입력했을 때 false 반환")
	@ParameterizedTest
	@ValueSource(strings = {"1234", "string"})
	public void isOneOrTwo_inputIs1234OrString_returnFalse_Test(String arg) throws
		NoSuchMethodException,
		IllegalAccessException,
		InvocationTargetException {

		//given

		//when
		boolean returnValue = isOneOrTwo(arg);

		//then
		assertThat(returnValue).isFalse();
	}

	private boolean isOneOrTwo(String input) throws
		NoSuchMethodException,
		IllegalAccessException,
		InvocationTargetException {

		Method method = userInterface.getClass().getDeclaredMethod("isOneOrTwo", String.class);
		method.setAccessible(true);
		return (boolean)method.invoke(userInterface, input);
	}
}
