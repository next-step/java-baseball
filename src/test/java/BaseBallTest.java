import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

	@Test
	@DisplayName("1~9 사이의 난수 생성")
	public void createRandom() {
		BaseBall baseBall = new BaseBall();
		assertThat(baseBall.createRandom()).isBetween(1, 9);
	}

	@Test
	@DisplayName("같은 숫자가 있다면 원래 값으로 return / 없다면 붙여서 return")
	public void baseBallContainRandom() {
		BaseBall baseBall = new BaseBall();
		assertThat(baseBall.baseBallContainRandom("12", 2)).isEqualTo("12");
		assertThat(baseBall.baseBallContainRandom("12", 3)).isEqualTo("123");
	}

	@Test
	@DisplayName("1~9 사이의 서로 다른 수로 이루어진 3자리의 수(야구공) 생성")
	public void createBaseBall() {
		BaseBall baseBall = new BaseBall();
		assertThat(baseBall.createBaseBall().length()).isEqualTo(3);
	}
	
	@Test
	@DisplayName("사용자가 입력한 값 체크 (중복값, 3자리 숫자 체크) / 잘못입력하면 true, 맞게 입력하면 false")
	public void userInputcheck() {
		BaseBall baseBall = new BaseBall();
		assertThat(baseBall.userInputcheck("123")).isFalse();
		assertThat(baseBall.userInputcheck("212")).isTrue();
		assertThat(baseBall.userInputcheck("1234")).isTrue();
	}

}
