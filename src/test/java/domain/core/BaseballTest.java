package domain.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream("123".getBytes(StandardCharsets.UTF_8)));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("스트라이크가 잘 출력 되는지")
    void print_strike() {

        // given
        Baseball baseball = Baseball.newInstance();
        int strikeCount = 2;

        // when
        try {
            Method print = baseball.getClass().getDeclaredMethod("print", int.class, int.class);
            print.setAccessible(true);
            print.invoke(baseball, strikeCount, 0);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // then
        assertEquals("2스트라이크\r\n", outContent.toString());
    }

    @Test
    @DisplayName("볼이 잘 출력 되는지")
    void print_ball() {

        // given
        Baseball baseball = Baseball.newInstance();
        int ballCount = 1;

        // when
        try {
            Method print = baseball.getClass().getDeclaredMethod("print", int.class, int.class);
            print.setAccessible(true);
            print.invoke(baseball, 0, ballCount);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // then
        assertEquals("1볼\r\n", outContent.toString());
    }

    @Test
    @DisplayName("낫싱이 잘 출력되는지")
    void print_nothing() {

        // given
        Baseball baseball = Baseball.newInstance();

        // when
        try {
            Method print = baseball.getClass().getDeclaredMethod("print", int.class, int.class);
            print.setAccessible(true);
            print.invoke(baseball, 0, 0);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // then
        assertEquals("낫싱\r\n", outContent.toString());
    }
}