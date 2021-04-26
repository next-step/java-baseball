import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @DisplayName("생성자 파라미터로 넘겨준 numberSize 만큼의 RightAnswer 값 생성")
    @Test
    void getNumberSizeTest() {
        // given
        int numberSize = 3;

        // when
        Computer computer = new Computer(numberSize);

        // then
        assertThat(computer.getNumberSize()).isEqualTo(numberSize);
    }

    @DisplayName("정답 비교 성공 테스트")
    @Test
    void correctCompareNumberWithTest() throws NoSuchFieldException, IllegalAccessException {
        // given
        int numberSize = 3;
        Computer computer = new Computer(numberSize);
        Field field = computer.getClass().getDeclaredField("answer");
        field.setAccessible(true);
        RightAnswer rightAnswer = (RightAnswer) field.get(computer);

        // when
        Result result = computer.compareNumberWith(rightAnswer.getNumber());

        // then
        assertThat(computer.isCorrectAnswer()).isTrue();
        assertThat(result.getStrikeCount()).isEqualTo(numberSize);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @DisplayName("정답 비교 실패 테스트")
    @Test
    void nothingCompareNumberWithTest() {
        // given
        int numberSize = 3;
        Computer computer = new Computer(numberSize);

        // when
        Result result = computer.compareNumberWith("000");

        // then
        assertThat(computer.isCorrectAnswer()).isFalse();
        assertThat(result.isNothing()).isTrue();
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @DisplayName("Calculate 메소드 테스트")
    @Nested
    class CalculateTest {
        private static final int NUMBER_SIZE = 3;
        private Computer computer;
        private Result result;
        private RightAnswer rightAnswer;
        private Method calculate;

        @BeforeEach
        void initBeforeEach() throws Exception {
            computer = new Computer(NUMBER_SIZE);
            result = new Result();

            Field field = computer.getClass().getDeclaredField("answer");
            field.setAccessible(true);

            calculate = computer.getClass().getDeclaredMethod("calculate", Result.class, char.class, int.class);
            calculate.setAccessible(true);

            rightAnswer = (RightAnswer) field.get(computer);
        }

        @DisplayName("스트라이크 테스트")
        @Test
        void strikeTest() throws InvocationTargetException, IllegalAccessException {
            // given
            int index = 0;
            char ch = rightAnswer.getNumber().charAt(index);

            // when
            calculate.invoke(computer, result, ch, index);

            // then
            assertThat(result.getStrikeCount()).isEqualTo(1);
            assertThat(result.getBallCount()).isEqualTo(0);
        }

        @DisplayName("볼 테스트")
        @Test
        void ballTest() throws IllegalAccessException, InvocationTargetException {
            // given
            int index = 0;
            int differentIndex = 1;
            char ch = rightAnswer.getNumber().charAt(index);

            // when
            calculate.invoke(computer, result, ch, differentIndex);

            // then
            assertThat(result.getStrikeCount()).isEqualTo(0);
            assertThat(result.getBallCount()).isEqualTo(1);
        }

        @DisplayName("낫싱 테스트")
        @Test
        void nothingTest() throws IllegalAccessException, InvocationTargetException {
            // given
            int index = 0;
            char ch = '0';

            // when
            calculate.invoke(computer, result, ch, index);

            // then
            assertThat(result.isNothing()).isTrue();
            assertThat(result.getStrikeCount()).isEqualTo(0);
            assertThat(result.getBallCount()).isEqualTo(0);
        }
    }

    @DisplayName("스트라이크가 numberSize 만큼 증가하면 정답")
    @Test
    void increaseStrikeCountTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // init
        final int numberSize = 3;
        Computer computer = new Computer(numberSize);
        Result result = new Result();

        assertThat(computer.getNumberSize()).isEqualTo(numberSize);
        assertThat(computer.isCorrectAnswer()).isFalse();
        assertThat(result.getStrikeCount()).isEqualTo(0);

        // given
        Method increaseStrikeCount = computer.getClass().getDeclaredMethod("increaseStrikeCount", Result.class);
        increaseStrikeCount.setAccessible(true);

        // when
        for (int i = 0; i< numberSize; i++) {
            increaseStrikeCount.invoke(computer, result);
        }

        // then
        assertThat(computer.isCorrectAnswer()).isTrue();
        assertThat(result.getStrikeCount()).isEqualTo(numberSize);
    }
}