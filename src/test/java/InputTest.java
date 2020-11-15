import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("인풋 클래스 테스트")
class InputTest {

	@Test
	@DisplayName("입력 받는 숫자를 List<Integer>로 변경되었는지 확인하는 테스트")
	void convertInputTest() {
		String number = "159";
		Input input = new Input(number);
		List<Integer> integers = input.convertInput();
		assertThat(integers).containsExactly(1,5,9);
	}
}