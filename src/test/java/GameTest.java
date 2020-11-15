
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
	private final Game game = new Game();

	@Test
	@DisplayName("컴퓨터가 생성한 타겟 숫자의 유효성 체크 (size : 3, range: 1-9)")
	void generateTargetNumberTest() {
		for (int i = 0; i < 100; i++) {
			Set<Integer> numbers = game.getTargetNumberSet();
			assertThat(numbers.size()).isEqualTo(3);
			assertThat(numbers.contains(0)).isFalse();
			assertThat(numbers.contains(10)).isFalse();
		}	
	}
	
	
	@Test
	@DisplayName("사용자에게 입력받은 숫자의 유효성 체크(실패) - 숫자가 아닌 경우")
	void answerNumberFailTestWithNoInteger() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String answer = "12a";
		
		Method method = getPriateMethod("isInteger");
		
		boolean result = (boolean) method.invoke(game, answer);
		assertThat(result).isFalse();
	}
	
	@Test
	@DisplayName("사용자에게 입력받은 숫자의 유효성 체크(실패) - 크기가 3이 아닌 경우")
	void answerNumberFailTestWithNo3Size() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String answer = "12";
		
		Method method = getPriateMethod("has3Numbers");
		
		boolean result = (boolean) method.invoke(game, answer);
		assertThat(result).isFalse();
	}
	
	@Test
	@DisplayName("사용자에게 입력받은 숫자의 유효성 체크(성공)")
	void answerNumberSuccessTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String answer = "126";
		
		boolean result1 = (boolean) getPriateMethod("isInteger").invoke(game, answer);
		assertThat(result1).isTrue();
		
		boolean result2 = (boolean) getPriateMethod("has3Numbers").invoke(game, answer);
		assertThat(result2).isTrue();
	}
	
	Method getPriateMethod(String methodName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method mehtod = game.getClass().getDeclaredMethod(methodName, String.class);
		mehtod.setAccessible(true);
		return mehtod;
	}
}