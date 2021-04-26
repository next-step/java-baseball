import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {

	@Test
	@DisplayName(value = "k-v STRIKE:1, BALL:2 은 1 스트라이크 2 볼 이라는 메세지를 생산한다")
	void oneStrikeTwoBall() {
		Referee referee = new Referee(135, "531");
		Map<Result, Integer> judge = referee.judge();

		UserInterface userInterface = new UserInterface();
		String message = userInterface.convertScoreToMessage(judge);

		assertThat(message).isEqualTo("1 스트라이크 2 볼");
	}

	@Test
	@DisplayName(value = "k-v STRIKE:3 이면 3 스트라이크 라는 메세지를 생성한다")
	void threeStrike() {
		Referee referee = new Referee(135, "135");
		Map<Result, Integer> judge = referee.judge();

		UserInterface userInterface = new UserInterface();
		String message = userInterface.convertScoreToMessage(judge);

		assertThat(message).isEqualTo("3 스트라이크");
	}

	@Test
	@DisplayName(value = "k-v BALL:3 이면 3 볼 이라는 메세지를 생성한다.")
	void threeBall() {
		Referee referee = new Referee(135, "513");
		Map<Result, Integer> judge = referee.judge();

		UserInterface userInterface = new UserInterface();
		String message = userInterface.convertScoreToMessage(judge);

		assertThat(message).isEqualTo("3 볼");
	}

	@Test
	@DisplayName(value = "일치하는 것이 없을 때 빈 문자열을 반환한다")
	void notMatched() {
		Referee referee = new Referee(135, "897");
		Map<Result, Integer> judge = referee.judge();

		UserInterface userInterface = new UserInterface();
		String message = userInterface.convertScoreToMessage(judge);

		assertThat(message).isEqualTo("");
	}

}
