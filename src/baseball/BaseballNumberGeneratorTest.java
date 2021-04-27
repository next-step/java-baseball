package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.util.GameStatus;

class BaseballNumberGeneratorTest {
	
    @DisplayName("3자리 숫자 생성 확인")
    @Test
    public void testCreateNumber() {
        Baseball numbers = BaseballNumberGenerator.CreateNumber();
        assertThat(numbers.getBaseballSize() == GameStatus.BALL_SIZE).isTrue();
    }

}
