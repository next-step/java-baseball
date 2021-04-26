import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {

	User user = new User();

	@Test
	@DisplayName("유저가 입력한 숫자의 길이 테스트")
	public void 유저_입력값_길이_체크() {
		String testInput1 = "486";

		assertThatCode(() -> {
			user.validateNumber(testInput1);
		}).doesNotThrowAnyException();

//		String testInput2 = "4868";

//		assertThatIllegalArgumentException().isThrownBy(() -> {
//			user.validateNumber(testInput2);
//		}).withMessage("입력한 숫자는 %s자리 입니다.", testInput2.length())
//				.withMessageContaining("세자리 숫자가 아닙니다.");
	}
}
