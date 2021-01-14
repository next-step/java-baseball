package baseball;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserIOTest {
    private static final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private static final PrintStream sysOut = System.out;

    @BeforeAll
    public static void setupUserIOTest() {
        System.setOut(new PrintStream(testOut));
    }

    @AfterAll
    public static void teardownUserIOTest() {
        System.setOut(sysOut);
    }

    @Test
    @DisplayName("Check get number from user")
    public void testInputNumber() {
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
}
