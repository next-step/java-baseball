package baseball;

import org.junit.jupiter.api.*;

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

    @Test
    @DisplayName("Test message is printed to stdout")
    void printMessage() {
        String msg = "TEST MESSAGE";

        UserOutput output = new UserOutput();
        output.printMessage(msg);

        assertEquals(msg, testOut.toString());
    }
}
