import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
	User user = new User();

	@Test
	@DisplayName("유저의 입력 테스트(성공)")
	public void 유저_입력값_성공() {
		String testInput1 = "486";

		assertThatCode(() -> {
			user.validateNumber(testInput1);
		}).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("유저의 문자 입력 테스트(실패)")
	public void 유저_입력값_문자열() {
		String testInput = "고고고";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			user.validateNumber(testInput);
		}).withMessage("입력 값 '%s'에는 문자열이 포함되어 있습니다.", testInput)
				.withMessageContaining("문자는 입력할 수 없습니다.");
	}

	@Test
	@DisplayName("유저가 입력한 숫자의 길이 테스트(실패)")
	public void 유저_입력값_길이_체크() {
		String testInput = "4868";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			user.validateNumber(testInput);
		}).withMessage("입력한 숫자는 %s자리 입니다.", testInput.length())
				.withMessageContaining("세자리 숫자가 아닙니다.");
	}

	@Test
	@DisplayName("유저가 입력한 숫자의 중복 테스트(실패)")
	public void 유저_입력값_중복_체크() {
		String testInput = "446";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			user.validateNumber(testInput);
		}).withMessage("입력 숫자 %s의 중복되는 수가 있습니다.", testInput)
				.withMessageContaining("중복되는 수가 있습니다.");
	}
}
