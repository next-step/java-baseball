import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

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

	@ParameterizedTest
	@DisplayName("사용자 입력 전체의 투구결과 확인")
	@MethodSource("parametersForGetResultMap")
	public void getResultMap(String answer, String input, Integer strike, Integer ball, Integer none) throws Exception {
	    // given
		Problem problem = new Problem(answer);

	    // when
		Map<Result, Integer> resultMap = problem.getResultMap(input);

	    // then
		assertEquals(strike, resultMap.get(Result.STRIKE));
		assertEquals(ball, resultMap.get(Result.BALL));
		assertEquals(none, resultMap.get(Result.NONE));
	}

	private static Object[] parametersForGetResultMap() {
		return new Object[] {
			new Object[] {"123", "123", 3, null, null},
			new Object[] {"123", "132", 1, 2, null},
			new Object[] {"123", "456", null, null, 3}
		};
	}
	
	@Test
	public void validate() throws Exception {
	    // given

	    // when
	    
	    // then
	}
}
