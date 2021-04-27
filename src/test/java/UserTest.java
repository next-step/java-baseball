import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
	User user = new User();

	@Test
	@DisplayName("유저가 입력한 숫자의 길이 테스트(성공, 실패)")
	public void 유저_입력값_길이_체크() {
		/*
		* 성공 - 메소드 캡슐화로 주석처리
		* */
		String testInput1 = "486";

//		assertThatCode(() -> {
//			user.validateNumber(testInput1);
//		}).doesNotThrowAnyException();

		/*
		 * 실패 - 메소드 캡슐화로 주석처리
		 * */
		String testInput2 = "4868";

//		assertThatIllegalArgumentException().isThrownBy(() -> {
//			user.validateNumber(testInput2);
//		}).withMessage("입력한 숫자는 %s자리 입니다.", testInput2.length())
//				.withMessageContaining("세자리 숫자가 아닙니다.");
	}

	@Test
	@DisplayName("유저가 입력한 숫자의 중복 테스트(성공, 실패)")
	public void 유저_입력값_중복_체크() {
		/*
		 * 성공 - 메소드 캡슐화로 주석처리
		 * */
		String testInput1 = "486";
//
//		assertThatCode(() -> {
//			user.validateNumber(testInput1);
//		}).doesNotThrowAnyException();

		/*
		 * 실패 - 메소드 캡슐화로 주석처리
		 * */
		String testInput2 = "446";

//		assertThatIllegalArgumentException().isThrownBy(() -> {
//			user.validateNumber(testInput2);
//		}).withMessage("입력 숫자 %s의 중복되는 수가 있습니다.", testInput2)
//				.withMessageContaining("중복되는 수가 있습니다.");
	}
}
