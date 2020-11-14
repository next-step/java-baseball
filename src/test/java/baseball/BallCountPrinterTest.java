package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallCountPrinterTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1:0:1스트라이크",
		"2:0:2스트라이크",
		"3:0:3스트라이크",
		"0:1:1볼",
		"0:2:2볼",
		"1:1:1스트라이크 1볼",
		"2:1:2스트라이크 1볼",
		"2:2:2스트라이크 2볼",
		"0:0:낫싱"
	}, delimiter = ':')
	public void makeText(final int strike, final int ball, final String textExpected) {
		BallCount ballCount = new BallCount(strike, ball);
		BallCountPrinter printer = new BallCountPrinter(ballCount);
		printer.print();

		assertThat(outputStreamCaptor.toString().trim()).isEqualTo(textExpected);
	}
}
