package baseball;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String WRONG_FORMAT_MSG = "잘못된 형식의 입력입니다.\n";
    private static final String NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private static Stream<Arguments> providerStartParams() {
        String[] inputs = {"123", "1", "456", "145", "451", "413", "123", "2"};
        String[][] MultipleInnings = {{"3스트라이크"}, {"낫싱", "1스트라이크", "1볼", "1볼 1스트라이크", "3스트라이크"}};

        String output = "";
        for (String[] innings : MultipleInnings) {
            output += Arrays.stream(innings).map(
                s -> NUMBER_MSG + s + "\n"
            ).collect(
                Collectors.joining("")
            );
            output += FINISH_MSG + RESTART_MSG;
        }

        return Stream.of(
            Arguments.of(String.join("\n", inputs), output)
        );
    }

    @ParameterizedTest
    @DisplayName("Test user's game start")
    @MethodSource("providerStartParams")
    void start(String input, String output) {
        Scanner scanner = new Scanner(input);
        MockUserIO mockUserIO = new MockUserIO(scanner);
        MockBuilder mockBuilder = new MockBuilder();

        Game game = new Game(mockUserIO, mockBuilder);
        game.start();

        assertEquals(output, mockUserIO.out);
    }

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

    private static Stream<Arguments> providerPlayParams() {
        String[] inputs = {"456", "145", "451", "413", "123"};
        String[] innings = {"낫싱", "1스트라이크", "1볼", "1볼 1스트라이크", "3스트라이크"};

        return Stream.of(
            Arguments.of(
                String.join("\n", inputs),
                Arrays.stream(innings).map(
                    s -> NUMBER_MSG + s + "\n"
                ).collect(
                    Collectors.joining("")
                ) + FINISH_MSG
            )
        );
    }

    @ParameterizedTest
    @DisplayName("Test user's game play")
    @MethodSource("providerPlayParams")
    void play(String input, String output) {
        Scanner scanner = new Scanner(input);
        MockUserIO mockUserIO = new MockUserIO(scanner);
        MockBuilder mockBuilder = new MockBuilder();

        Game game = new Game(mockUserIO, mockBuilder);
        game.play();

        assertEquals(output, mockUserIO.out);
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

class MockBuilder extends Number.Builder {
    @Override
    public Number byRandom() throws Exception{
        int[] digits = {1, 2, 3};
        return new Number(digits);
    }
}
