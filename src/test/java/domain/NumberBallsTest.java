package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("숫자볼 모음")
public class NumberBallsTest {
    
    @Test
    @DisplayName("게임 시작 시 생성되는 숫자볼은 3개")
    public void ballsSizeThree() throws Exception {
        NumberBalls numberBalls = new NumberBalls();
        assertThat(numberBalls.isSize(3)).isTrue();
    }
}
