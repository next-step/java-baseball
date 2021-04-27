package view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import number.Numbers;

public class ScannerInputViewTest {

	@Test
	@DisplayName("사용자가 입력한 숫자가 나와야 한다.")
	public void inputNumbersTest() {
		// given
		String userInputNumbers = "123";
		ScannerInputView scannerInputView = generateInputView(userInputNumbers);

		// when
		Numbers numbers = scannerInputView.inputNumbers();

		// then
		assertThat(numbers).isEqualTo(Numbers.of(userInputNumbers));
	}

	@Test
	@DisplayName("사용자가 입력한 재시작 명령이 나와야 한다.")
	public void inputRestartCommand() {
		String restartCommand = "1";
		ScannerInputView scannerInputView = generateInputView(restartCommand);

		String inputValue = scannerInputView.inputRestartCommand();

		assertThat(inputValue).isEqualTo(restartCommand);
	}

	private ScannerInputView generateInputView(String userInput) {
		InputStream inputStream = new ByteArrayInputStream(userInput.getBytes(StandardCharsets.UTF_8));
		return new ScannerInputView(inputStream);
	}
}
