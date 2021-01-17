package baseball;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String WRONG_FORMAT_MSG = "잘못된 형식의 입력입니다.\n";

    private static Stream<Arguments> providerRestartParams() {
        return Stream.of(
            Arguments.of("1", RESTART_MSG, true),
            Arguments.of("2", RESTART_MSG, false),
            Arguments.of("3\n1", RESTART_MSG + WRONG_FORMAT_MSG + RESTART_MSG, true)
        );
    }

    @ParameterizedTest
    @DisplayName("Test user's restart input converted successfully with guide messages")
    @MethodSource("providerRestartParams")
    void restart(String input, String output, boolean expected) {
        Scanner scanner = new Scanner(input);
        MockUserIO mockUserIO = new MockUserIO(scanner);

        Game game = new Game(
            mockUserIO,
            new Number.Builder()
        );

        boolean status = game.restart();
        assertEquals(output, mockUserIO.out);
        assertEquals(expected, status);
    }
}

class MockUserIO extends UserIO {
    public String out;

    public MockUserIO(Scanner scanner) {
        super(scanner);
        out = "";
    }

    @Override
    public void printMsg(String msg) {
        out += msg;
    }
}