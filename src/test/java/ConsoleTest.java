import baseball.domain.Score;
import baseball.service.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleTest {

    private static final String NEW_LINE = "\r\n";
    private Console console;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        scanner = new Scanner(System.in);
        console = new Console(scanner);
    }

    @AfterEach
    void finishAll() {
        scanner.close();
    }

    @Test
    @DisplayName("종료 플래그 확인, 3 스트라이크 결과일 경우 True")
    void result_three_strike() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertThat((boolean) getMethod("isFinish", Score.class).invoke(console, new Score(3, 0))).isTrue();
    }

    @Test
    @DisplayName("종료 플래그 확인, 3 스트라이크 아닐 경우 False")
    void result_one_strike_one_ball() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertThat((boolean) getMethod("isFinish", Score.class).invoke(console, new Score(1, 1))).isFalse();
    }

    @Test
    @DisplayName("원볼일 경우 프린트 메시지 출력 확인")
    void print_one_ball_score() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ByteArrayOutputStream outputStream = printMethod(new Score(0, 1));
        assertThat(outputStream.toString()).hasToString(new Score(0, 1).getBall() + " 볼" + NEW_LINE);
    }

    @Test
    @DisplayName("쓰리볼일 경우 프린트 메시지 출력 확인")
    void print_three_ball_score() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ByteArrayOutputStream outputStream = printMethod(new Score(0, 3));
        assertThat(outputStream.toString()).hasToString(new Score(0, 3).getBall() + " 볼" + NEW_LINE);
    }

    @Test
    @DisplayName("낫싱일 경우 프린트 메시지 출력 확인")
    void print_four_ball_score() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ByteArrayOutputStream outputStream = printMethod(new Score(0, 4));
        assertThat(outputStream.toString()).hasToString("낫싱" + NEW_LINE);
    }

    @Test
    @DisplayName("스트라이크 볼 혼합 메시지 출력 확인")
    void print_one_strike_one_ball_score() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ByteArrayOutputStream outputStream = printMethod(new Score(1, 1));
        assertThat(outputStream.toString()).hasToString(new Score(1, 1).getStrike() + " 스트라이크 " + new Score(1, 1).getBall() + " 볼" + NEW_LINE);
    }

    @Test
    @DisplayName("원 스트라이크 메시지 출력 확인")
    void print_one_strike_score() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ByteArrayOutputStream outputStream = printMethod(new Score(1, 0));
        assertThat(outputStream.toString()).hasToString(new Score(1, 0).getStrike() + " 스트라이크" + NEW_LINE);
    }

    @Test
    @DisplayName("쓰리 스트라이크 메시지 출력 확인")
    void print_three_strike_score() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ByteArrayOutputStream outputStream = printMethod(new Score(3, 0));
        assertThat(outputStream.toString()).hasToString(new Score(3, 0).getStrike() + " 스트라이크" + NEW_LINE + "3개의 숫자를 모두 맞히셨습니다! 게임종료" + NEW_LINE);
    }

    @Test
    @DisplayName("중복 입력값에 대한 플래그 확인")
    void check_duplicate_number() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = getMethod("isDuplicateNumber", int.class);
        assertThat((boolean) method.invoke(console, 333)).isTrue();
        assertThat((boolean) method.invoke(console, 123)).isFalse();
    }

    private ByteArrayOutputStream printMethod(Score score) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ByteArrayOutputStream outputStream = systemOutput();
        Method method = getMethod("print", Score.class);
        method.invoke(console, score);
        return outputStream;
    }

    private Method getMethod(String name, Class<?> aClass) throws NoSuchMethodException {
        Method method = console.getClass().getDeclaredMethod(name, aClass);
        method.setAccessible(true);
        return method;
    }

    private ByteArrayOutputStream systemOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

}
