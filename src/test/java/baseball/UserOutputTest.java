package baseball;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserOutputTest {
    private static final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private static final PrintStream sysOut = System.out;

    @BeforeAll
    public static void setupAll() {
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void tearDown() {
        testOut.reset();
    }

    @AfterAll
    public static void teardownAll() {
        System.setOut(sysOut);
    }

    @ParameterizedTest
    @DisplayName("Test output is proper information message with argument")
    @CsvSource({
        "0, 0, '낫싱\n'",
        "1, 0, '1볼\n'",
        "0, 2, '2스트라이크\n'",
        "2, 1, '2볼 1스트라이크\n'",
    })
    void printInfo(int ball, int strike, String expected) {
        UserOutput output = new UserOutput();
        output.printInfo(ball, strike);

        assertEquals(expected, testOut.toString());
    }

    @Test
    @DisplayName("Test output is finish message")
    void printFinish() {
        UserOutput output = new UserOutput();
        output.printFinish();

        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", testOut.toString());
    }
}