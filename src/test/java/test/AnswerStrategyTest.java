package test;

import baseball.model.strategy.LinearStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnswerStrategyTest {
    @Test
    @DisplayName("숫자 야구의 정답의 사이즈를 확인하는 테스트")
    void answerSizeTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final int answerSize = linearStrategy.size();

        assertThat(answerSize).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 야구의 정답을 순차적으로 꺼내는 테스트")
    void popTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();

        assertThat(linearStrategy.pop()).isEqualTo(1);
        assertThat(linearStrategy.pop()).isEqualTo(2);
        assertThat(linearStrategy.pop()).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 야구의 정답 사이즈 이상으로 꺼낼 때, 에러 테스트")
    void popErrorTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        linearStrategy.pop();
        linearStrategy.pop();
        linearStrategy.pop();

        assertThrows(IllegalStateException.class, linearStrategy::pop);
    }
}
