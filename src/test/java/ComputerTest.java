import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {
    private static final String REGULAR_EXPRESSION_FORMAT = "[1-9]{%d}";
    private static final int NUMBER_SIZE = 3;
    private static final String REGULAR_EXPRESSION = String.format(REGULAR_EXPRESSION_FORMAT, NUMBER_SIZE);
    private static final String RANDOM_NUMBER = "123";

    @DisplayName("생성자 파라미터로 넘겨준 numberSize 만큼의 RightAnswer 값 생성")
    @Test
    void getNumberSizeTest() {
        // given
        RightAnswer answer = new RightAnswer(RANDOM_NUMBER);

        // when
        Computer computer = new Computer(answer, REGULAR_EXPRESSION);

        // then
        assertThat(computer.getNumberSize()).isEqualTo(NUMBER_SIZE);
    }

    @Nested
    class ValidateTest {
        private final static String ERROR_FORMAT = "정확한 값을 입력해주세요. 현재 입력값 : %s";

        private Computer computer;

        @BeforeEach
        void initBeforeEach() {
            RightAnswer rightAnswer = new RightAnswer(RANDOM_NUMBER);
            computer = new Computer(rightAnswer, REGULAR_EXPRESSION);
        }

        @DisplayName("Input Number Size 불일치")
        @Test
        void validateNumberSize() {
            String smallSizeInput = "1";

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> computer.validateInput(smallSizeInput))
                    .withMessage(ERROR_FORMAT, smallSizeInput);


            String largeSizeInput = "123456";

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> computer.validateInput(largeSizeInput))
                    .withMessage(ERROR_FORMAT, largeSizeInput);
        }

        @DisplayName("입력값이 [1-9] 가 아닌 다른 숫자 또는 문자가 포함됨")
        @Test
        void validateInputContainsZero() {
            String containsZeroInput = "000";

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> computer.validateInput(containsZeroInput))
                    .withMessage(ERROR_FORMAT, containsZeroInput);


            String containsCharacterInput = "abc";

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> computer.validateInput(containsCharacterInput))
                    .withMessage(ERROR_FORMAT, containsCharacterInput);
        }
    }

    @DisplayName("정답 비교 성공 테스트")
    @Test
    void correctCompareNumberWithTest() {
        // given
        RightAnswer answer = new RightAnswer(RANDOM_NUMBER);
        Computer computer = new Computer(answer, REGULAR_EXPRESSION);

        // when
        Result result = computer.compareNumberWith(RANDOM_NUMBER);

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getStrikeCount()).isEqualTo(NUMBER_SIZE);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @DisplayName("정답 비교 실패 테스트")
    @Test
    void nothingCompareNumberWithTest() {
        // given
        RightAnswer answer = new RightAnswer(RANDOM_NUMBER);
        Computer computer = new Computer(answer, REGULAR_EXPRESSION);

        // when
        String wrongNumber = "456";
        Result result = computer.compareNumberWith(wrongNumber);

        // then
        assertThat(result.isSuccess()).isFalse();
        assertThat(result.isNothing()).isTrue();
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @DisplayName("Calculate 메소드 테스트")
    @Nested
    class CalculateTest {
        private Computer computer;
        private RightAnswer rightAnswer;
        private Method calculate;

        @BeforeEach
        void initBeforeEach() throws Exception {
            rightAnswer = new RightAnswer(RANDOM_NUMBER);
            computer = new Computer(rightAnswer, REGULAR_EXPRESSION);

            calculate = computer.getClass().getDeclaredMethod("calculate", Result.class, char.class, int.class);
            calculate.setAccessible(true);
        }

        @DisplayName("스트라이크 테스트")
        @Test
        void strikeTest() throws InvocationTargetException, IllegalAccessException {
            // given
            int index = 0;
            char ch = rightAnswer.getNumber().charAt(index);
            Result result = new Result();

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
            Result result = new Result();

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
            Result result = new Result();

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
        RightAnswer answer = new RightAnswer(RANDOM_NUMBER);
        Computer computer = new Computer(answer, REGULAR_EXPRESSION);
        Result result = new Result();

        assertThat(result.isSuccess()).isFalse();
        assertThat(result.getStrikeCount()).isEqualTo(0);

        // given
        Method increaseStrikeCount = computer.getClass().getDeclaredMethod("increaseStrikeCount", Result.class);
        increaseStrikeCount.setAccessible(true);

        // when
        for (int i = 0; i < NUMBER_SIZE; i++) {
            increaseStrikeCount.invoke(computer, result);
        }

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getStrikeCount()).isEqualTo(NUMBER_SIZE);
    }
}