import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	
	@Test
	public void exist() throws Exception {
	    // given

	    // when
	    
	    // then
	}
	
	@Test
	public void match() throws Exception {
	    // given

	    // when
	    
	    // then
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
