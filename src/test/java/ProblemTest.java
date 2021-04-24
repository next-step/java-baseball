import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ProblemTest {
	
	@Test
	@DisplayName("초기화 된 숫자에 0이 없는지 확인")
	public void initNumber() throws Exception {
	    // given
	    Problem problem = new Problem();
		Field field = problem.getClass().getDeclaredField("answer");
		field.setAccessible(true);
	    
	    // when
		problem.initNumber();
		String answer = (String)field.get(problem);

	    // then
		assertThat(answer).doesNotContain("0");
	}

	@ParameterizedTest
	@DisplayName("사용자 입력 첫번째 숫자의 투구결과 확인")
	@MethodSource("parametersForGetResult")
	public void getResult(String answer, String input, int index, Result expected) throws Exception {
	    // given
		Problem problem = new Problem(answer);
		Method method = problem.getClass().getDeclaredMethod("getResult", String.class, int.class);
		method.setAccessible(true);

	    // when
		Result result = (Result)method.invoke(problem, input, index);

		// then
		assertEquals(expected, result);
	}

	private static Object[] parametersForGetResult() {
		return new Object[] {
			new Object[] {"123", "100", 0, Result.STRIKE},
			new Object[] {"123", "200", 0, Result.BALL},
			new Object[] {"123", "400", 0, Result.NONE}
		};
	}
	
	@Test
	public void getResultMap() throws Exception {
	    // given

	    // when
	    
	    // then
	}
	
	@Test
	public void validate() throws Exception {
	    // given

	    // when
	    
	    // then
	}
}
