package baseball;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    private static final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private static final PrintStream sysOut = System.out;

    @BeforeAll
    public static void setupAll() {
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void teardown() {
        testOut.reset();
    }

    @AfterAll
    public static void teardownAll() {
        System.setOut(sysOut);
    }

    @Test
    @DisplayName("Test int value is returned from stdin with print message to stdout")
    void scanInt() {
        Scanner scanner = new Scanner("123");
        String msg = "TEST MESSAGE";

        UserInput input = new UserInput(scanner);
        int number = input.scanInt(msg);

        assertEquals(msg, testOut.toString());
        assertEquals(123, number);
    }
}
