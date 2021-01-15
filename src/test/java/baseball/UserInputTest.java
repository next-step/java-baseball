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
    @DisplayName("Test output is number message and return of user input")
    void inputNumber() {
        Scanner scanner = new Scanner("123");

        UserInput input = new UserInput(scanner);
        int number = input.inputNumber();

        assertEquals("숫자를 입력해주세요 : ", testOut.toString());
        assertEquals(123, number);
    }

    @Test
    @DisplayName("Test output is restart message and return of user input")
    void inputRestart() {
        Scanner scanner = new Scanner("1");

        UserInput input = new UserInput(scanner);
        int isRestart = input.inputRestart();

        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", testOut.toString());
        assertEquals(1, isRestart);
    }
}
