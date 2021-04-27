import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameLogicTest {
	BaseballGameNumber baseballGameNumber;
	BaseballGameLogic baseballGameLogic;

	@BeforeEach
	void setUp() {
		baseballGameLogic = new BaseballGameLogic();
		baseballGameNumber = new BaseballGameNumber();
		baseballGameNumber.makeNumber();
	}


	@Test
	@DisplayName("스트라이크 / 볼 / 낫싱 로직 정상 여부 확인")
	public void is_logic_ok() {
		String targetInput;

		targetInput = "0" + baseballGameNumber.getNumber().substring(1);
		assertThat(baseballGameLogic.getScore(baseballGameNumber.getNumber(), targetInput).equals("2 스트라이크 ")).isTrue();
		targetInput = baseballGameNumber.getNumber();
		assertThat(baseballGameLogic.getScore(baseballGameNumber.getNumber(), targetInput).equals("3 스트라이크 ")).isTrue();
		targetInput = baseballGameNumber.getNumber().substring(2) + baseballGameNumber.getNumber().substring(0, 2);
		assertThat(baseballGameLogic.getScore(baseballGameNumber.getNumber(), targetInput).equals("3 볼")).isTrue();
		targetInput = baseballGameNumber.getNumber().substring(0, 1) + baseballGameNumber.getNumber().substring(2, 3) + baseballGameNumber.getNumber().substring(1, 2);
		assertThat(baseballGameLogic.getScore(baseballGameNumber.getNumber(), targetInput).equals("1 스트라이크 2 볼")).isTrue();
		targetInput = "000";
		assertThat(baseballGameLogic.getScore(baseballGameNumber.getNumber(), targetInput).equals("낫싱")).isTrue();
	}
}
