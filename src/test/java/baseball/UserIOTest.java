package baseball;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserIOTest {
    private static final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private static final PrintStream sysOut = System.out;

    @BeforeAll
    public static void setupAllUserIOTest() {
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void teardownEachUserIOTestMethod() {
        testOut.reset();
    }

    @AfterAll
    public static void teardownAllUserIOTest() {
        System.setOut(sysOut);
    }

    @Test
    @DisplayName("Test input is converted to ArrayList<Integer> successfully")
    public void inputNumber() {
        Scanner scanner = new Scanner("123");

        UserIO io = new UserIO(scanner);
        ArrayList<Integer> number = io.inputNumber();

        assertEquals(
            "숫자를 입력해주세요 : ",
            testOut.toString()
        );
        assertEquals(
            number,
            new ArrayList<>(
                Arrays.asList(1, 2, 3)
            )
        );
    }

    @ParameterizedTest
    @DisplayName("Test input is converted to bool successfully")
    @CsvSource({"1,true", "2,false"})
    public void inputIsRestart(String input, Boolean expected) {
        Scanner scanner = new Scanner(input);

        UserIO io = new UserIO(scanner);
        Boolean isRestart = io.inputIsRestart();

        assertEquals(
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n",
            testOut.toString()
        );
        assertEquals(expected, isRestart);
    }

    @ParameterizedTest
    @DisplayName("Test output is printed with argument successfully")
    @CsvSource({
        "0, 0, '낫싱\n'",
        "1, 0, '1볼\n'",
        "0, 2, '2스트라이크\n'",
        "2, 1, '2볼 1스트라이크\n'",
    })
    public void outputInfo(Integer ball, Integer strike, String expected) {
        UserIO io = new UserIO(new Scanner(""));
        io.outputInfo(ball, strike);

        assertEquals(
            expected,
            testOut.toString()
        );
    }

    @Test
    @DisplayName("Test output is printed successfully")
    public void outputIsFinish() {
        UserIO io = new UserIO(new Scanner(""));
        io.outputIsFinish();

        assertEquals(
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n",
            testOut.toString()
        );
    }
}
