package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleInputScannerTest {
    private final InputStream stdin = System.in;
    private ConsoleInputScanner scanner;
    @BeforeEach
    public void setUp(){
        scanner = new ConsoleInputScanner();
    }

    @ParameterizedTest
    @ValueSource(strings = { "123", "353", "523" })
    public void scanner(final String input) {
        try {
            System.setIn(new ByteArrayInputStream((input + "\r\n").getBytes()));

            String inputText = scanner.inputNumberLength3();

            assertThat(inputText).isEqualTo(input);
        } finally {
            System.setIn(stdin);
        }
    }
}
