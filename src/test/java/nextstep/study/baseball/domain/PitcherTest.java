package nextstep.study.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import nextstep.study.baseball.util.BaseballUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("투수 테스트")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class PitcherTest {

	@Test
	@DisplayName("01. 사용자에게 값 입력받기")
	void testInputNumbers() {
		InputStream origIn = System.in;
		try {
			String data = "123";
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);

			Pitcher pitcher = new Pitcher(scanner);
			String strNum = pitcher.makeMixBallNumber();

			assertThat(strNum).isEqualTo(data);
		} finally {
			System.setIn(origIn);
		}
	}

	@Test
	@DisplayName("02. 사용자에게 잘못된 값을 입력받앗을 경우 체크")
	void testInputWrongNumbers() {
		InputStream origIn = System.in;
		try {
			String data = "abc";
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);

			Pitcher pitcher = new Pitcher(scanner);
			String strNum = pitcher.makeMixBallNumber(false); //재입력안되도록

			boolean isValid = BaseballUtil.validationNumber(strNum);

			assertThat(isValid).isFalse();

		} finally {
			System.setIn(origIn);
		}
	}

	@Test
	@DisplayName("03. 사용자에게 정상적인 값을 입력받앗을 경우 체크")
	void testInputValidNumbers() {
		InputStream origIn = System.in;
		try {
			String data = "123";
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);

			Pitcher pitcher = new Pitcher(scanner);
			String strNum = pitcher.makeMixBallNumber();

			boolean isValid = BaseballUtil.validationNumber(strNum);

			assertThat(isValid).isTrue();

		} finally {
			System.setIn(origIn);
		}
	}

}
