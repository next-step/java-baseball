package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConsoleInputScannerTest {
	private final InputStream stdin = System.in;

	@AfterEach
	public void restore() {

		System.setIn(stdin);
	}

	@DisplayName("Scanner 입력 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"123", "356", "523"})
	public void scanner(final String input) {
		System.setIn(new ByteArrayInputStream((input + "\r\n").getBytes()));
		ConsoleInputScanner consoleScanner = new ConsoleInputScanner();
		String inputText = consoleScanner.inputNumberLength3();
		assertThat(inputText).isEqualTo(input);
	}

	@DisplayName("Scanner 입력 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	public void scan1or2(final String input) {
		System.setIn(new ByteArrayInputStream((input + "\r\n").getBytes()));
		ConsoleInputScanner consoleScanner = new ConsoleInputScanner();
		String inputText = consoleScanner.inputNumber1Or2();
		assertThat(inputText).isEqualTo(input);
	}
}
