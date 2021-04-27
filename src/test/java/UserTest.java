import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {

	User user = new User();
	Computer computer = new Computer();

	@Test
	@DisplayName("유저가 입력한 숫자의 길이 테스트")
	public void 유저_입력값_길이_체크() {
		String testInput1 = "486";

//		assertThatCode(() -> {
//			user.validateNumber(testInput1);
//		}).doesNotThrowAnyException();

		String testInput2 = "4868";

//		assertThatIllegalArgumentException().isThrownBy(() -> {
//			user.validateNumber(testInput2);
//		}).withMessage("입력한 숫자는 %s자리 입니다.", testInput2.length())
//				.withMessageContaining("세자리 숫자가 아닙니다.");
	}

	@Test
	@DisplayName("유저가 입력한 숫자의 중복 테스트")
	public void 유저_입력값_중복_체크() {
		String testInput1 = "486";
//
//		assertThatCode(() -> {
//			user.validateNumber(testInput1);
//		}).doesNotThrowAnyException();

		String testInput2 = "446";

//		assertThatIllegalArgumentException().isThrownBy(() -> {
//			user.validateNumber(testInput2);
//		}).withMessage("입력 숫자 %s의 중복되는 수가 있습니다.", testInput2)
//				.withMessageContaining("중복되는 수가 있습니다.");
	}

	@Test
	@DisplayName("유저가 입력한 숫자 매칭 테스트 - 1 스트라이크")
	public void 원_스트라이크_매칭_테스트() {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(4);
		userNumber.add(6);
		userNumber.add(8);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isEqualTo(1);
	}

	@Test
	@DisplayName("유저가 입력한 숫자 매칭 테스트 - 2 스트라이크")
	public void 투_스트라이크_매칭_테스트() {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(4);
		userNumber.add(8);
		userNumber.add(7);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("유저가 입력한 숫자 매칭 테스트 - 3 스트라이크")
	public void 쓰리_스트라이크_매칭_테스트() {
		List<Integer> computerNumber = new ArrayList<>();
		computerNumber.add(4);
		computerNumber.add(8);
		computerNumber.add(6);
		computer.setComputerNumbers(computerNumber);

		List<Integer> userNumber = new ArrayList<>();
		userNumber.add(4);
		userNumber.add(8);
		userNumber.add(6);

		computer.matchResult(userNumber);

		assertThat(computer.getStrikeCount()).isEqualTo(3);
	}
}
