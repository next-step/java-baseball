package com.kakaocorp.baseball.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class UserInterfaceTest {
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Ignore
    void threeDigitNumAsInput() {
        String input = "123";
        InputStream in;
        UserInterface userInterface = new UserInterface();

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(userInterface.scanNextGuessingNum()).isEqualTo(123);
    }

    @Ignore
    void zeroInFrontIsIgnored() {
        String input = "0456";
        InputStream in;
        UserInterface userInterface = new UserInterface();

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(userInterface.scanNextGuessingNum()).isEqualTo(456);
    }

    @Ignore
    @CsvSource({"1,false", "2,true"})
    void whetherToFinishGame(String input, boolean expected) {
        InputStream in;
        UserInterface userInterface = new UserInterface();

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(userInterface.scanPlayerWantsToEnd()).isEqualTo(expected);
    }

    @Test
    void finishGameAskingMessage() {
        UserInterface userInterface = new UserInterface();
        userInterface.printFinishGameAskingMessage();

        assertThat(out.toString()).contains("시작", "종료");
    }

    @Test
    void nextGuessNumAskingMessage() {
        UserInterface userInterface = new UserInterface();
        userInterface.printNextPlayerPickMessage();

        assertThat(out.toString()).contains("숫자", "입력");
    }

    @ParameterizedTest
    @CsvSource({"0,0,꽝!", "2,0,2 스트라이크",
            "0,1,1 볼", "1,2,1 스트라이크 2 볼"})
    void statusMessageForEachGuess(int strikes, int balls, String expected) {
        UserInterface userInterface = new UserInterface();
        userInterface.printStatusMessageStrikesBalls(strikes, balls);

        assertThat(out.toString().trim()).isEqualTo(expected);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}
