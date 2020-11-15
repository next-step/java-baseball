package domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballAnswerTest {
    private BaseballAnswer answer = new BaseballAnswer();

    @Nested
    @DisplayName("정답 숫자 생성 테스트")
    class MakeAnswerTest {
        @BeforeEach
        void setUp() {
            answer.makeAnswer();
        }

        @Test
        @Order(1)
        @DisplayName("3자리 생성되는지 확인")
        void threeNumberTest() {
            assertThat(answer.getAnswer().length).isEqualTo(3);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        @Order(2)
        @DisplayName("1-9만 포함하는지 확인")
        void noZeroTest(int index) {
            assertThat(answer.getAnswer()[index]).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }

        @Test
        @Order(3)
        @DisplayName("서로 다른 숫자인지 확인")
        void allDifferentTest() {
            assertThat(answer.getAnswer()[0]).isNotEqualTo(answer.getAnswer()[1]).isNotEqualTo(answer.getAnswer()[2]);
            assertThat(answer.getAnswer()[1]).isNotEqualTo(answer.getAnswer()[0]).isNotEqualTo(answer.getAnswer()[2]);
            assertThat(answer.getAnswer()[2]).isNotEqualTo(answer.getAnswer()[0]).isNotEqualTo(answer.getAnswer()[1]);
        }
    }
}
