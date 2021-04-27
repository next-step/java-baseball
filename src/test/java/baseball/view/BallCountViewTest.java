package baseball.view;

import baseball.config.AppContext;
import baseball.domain.BallCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallCountViewTest {

	private BallCountView ballCountView;
	private OutputStream out;

	@BeforeEach
	void setUp() {
		System.setIn(new ByteArrayInputStream("123".getBytes()));

		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		ballCountView = AppContext.getInstance().getBallCountView();
	}

	@Test
	@DisplayName("사용자 번호 입력")
	void requestRandomNumbers() {
		String input = ballCountView.requestRandomNumbers();
		assertEquals(input, "123");
	}

	@Test
	@DisplayName("난수와 사용자 입력 수를 비교 결과를 출력")
	void responseBallCount() throws IOException {
		ballCountView.responseBallCount(new BallCount(2, 0));
		assertEquals(out.toString(), "2스트라이크" + System.lineSeparator());
	}
}