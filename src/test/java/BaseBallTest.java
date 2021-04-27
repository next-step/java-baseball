import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {
    private BaseBall baseball;
    private Result result;
    int[] answer;
    GameOutput gameOutput;
    GameInput gameInput;

    @BeforeEach
    void prepare() throws NoSuchFieldException, IllegalAccessException {
        baseball = new BaseBall();
        result = new Result();
        result.setBalls(2);
        result.setStrikes(1);

        gameOutput =GameOutput.getInstance();
        gameInput =GameInput.getInstance();
        gameInput.setGameLength(3);
        gameInput.setLowerBound(1);
        gameInput.setUpperBound(9);

        Field answerField = baseball.getClass().getDeclaredField("answer");
        answerField.setAccessible(true);
        answerField.set(baseball, new int[]{3, 4, 5});
        answer = (int[]) answerField.get(baseball);

        Field outputField = baseball.getClass().getDeclaredField("gameOutput");
        outputField.setAccessible(true);
        outputField.set(baseball, gameOutput);

        Field inputField = baseball.getClass().getDeclaredField("gameInput");
        inputField.setAccessible(true);
        inputField.set(baseball, gameInput);

    }

    @Test
    @DisplayName("정답 배열이 정상 생성되었는지 확인한다.")
    void init_generateAnswerArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method initMethod = baseball.getClass().getDeclaredMethod("init");
        initMethod.setAccessible(true);
        initMethod.invoke(baseball);

        Field answerField = baseball.getClass().getDeclaredField("answer");
        answerField.setAccessible(true);
        answer = (int[]) answerField.get(baseball);

        assertNotNull(answer);
        assertEquals(answer.length, 3);
        assertNotEquals(answer[0], answer[1]);
        assertNotEquals(answer[1], answer[2]);
        assertTrue(answer[0] >= 1 && answer[0] <= 9);
        assertTrue(answer[1] >= 1 && answer[1] <= 9);
        assertTrue(answer[2] >= 1 && answer[2] <= 9);
    }

    @Test
    @DisplayName("어떤 수가 정답에 포함되어 있는지 확인한다.")
    void isContain_shouldReturnTrueForParameterNumberExist() {
        assertTrue(baseball.isContain(3));
        assertTrue(baseball.isContain(4));
        assertTrue(baseball.isContain(5));
        assertFalse(baseball.isContain(6));
    }

    @Test
    @DisplayName("Strike인지 확인한다.")
    void isStrike_shouldReturnCountForNumberInRightPosition() {
        assertTrue(baseball.isStrike(0, 3));
        assertTrue(baseball.isStrike(1, 4));
        assertTrue(baseball.isStrike(2, 5));
        assertFalse(baseball.isStrike(0, 1));
        assertFalse(baseball.isStrike(0, 5));
    }

    @Test
    @DisplayName("Strike가 아니고 정답에 포함된 숫자인지, 즉 Ball인지 확인한다.")
    void isBall_shouldReturnCountForNumberInAnswerAndNotStrike() {
        assertFalse(baseball.isBall(0, 3));
        assertFalse(baseball.isBall(1, 4));
        assertFalse(baseball.isBall(2, 5));
        assertFalse(baseball.isBall(0, 1));
        assertTrue(baseball.isBall(0, 5));
    }

    @Test
    @DisplayName("입력에 따라 판단 Method와 Hints 출력 Method를 부른다")
    void check_shouldCallJudgeCallShowHints() {
        baseball.check("435");
        baseball.check("789");
    }

    @Test
    @DisplayName("입력에 따라 Ball과 Strike 수를 판단한다.")
    void judge_shouldJudgeForResult() {
        result.setBalls(0);
        result.setStrikes(0);
        baseball.judge("435", result, 0);
        assertEquals(result.getBalls(), 1);
        result.setBalls(0);
        result.setStrikes(0);
        baseball.judge("345", result, 0);
        assertEquals(result.getStrikes(), 1);
        baseball.judge("345", result, 1);
        assertEquals(result.getStrikes(), 2);
        baseball.judge("345", result, 2);
        assertEquals(result.getStrikes(), 3);
    }
    @Test
    @DisplayName("입력에 따라 게임을 진행한다.")
    void playGames_shouldPlayGame() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        System.setIn(new ByteArrayInputStream("1234\n045\nabc\n789\n345\n2".getBytes()));

        Field scannerField = gameInput.getClass().getDeclaredField("s");
        scannerField.setAccessible(true);
        scannerField.set(gameInput, new Scanner(System.in));

        Method playMethod = baseball.getClass().getDeclaredMethod("playGame");
        playMethod.setAccessible(true);
        playMethod.invoke(baseball);
    }
}
