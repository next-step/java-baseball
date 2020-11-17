package baseball.display;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.report.Report;

class DisplayTest {

	private PrintStream printStream;
	private ByteArrayOutputStream outputStream;
	private Display display;

	@BeforeEach
	void setup() {
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);
		display = new DefaultDisplay(printStream);
	}

	@Test
	@DisplayName("숫자 요청 메시지")
	void toCheckAskMessage() {
		display.askMessage();
		assertThat(outputStream.toString()).contains("숫자를 입력해 주세요 : ");
	}

	@Test
	@DisplayName("결과 메시지")
	void toCheckResultMessage() {
		Report report = new Report(2, 1);

		display.resultMessage(report);
		assertThat(outputStream.toString()).contains("2스트라이크1볼");
	}

	@Test
	@DisplayName("재실행 메시지")
	void restartMessage() {
		display.restartMessage();
		assertThat(outputStream.toString()).contains("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요 : ");
	}

	@Test
	@DisplayName("에러 메시지")
	void errorMessage() {
		display.errorMessage("invalid requestNumbers");
		assertThat(outputStream.toString()).contains("invalid requestNumbers");
	}
}
