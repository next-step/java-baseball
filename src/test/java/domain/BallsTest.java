package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("숫자볼 모음")
public class BallsTest {

    @Test
    @DisplayName("게임 시작 시 생성되는 숫자볼은 3개")
    public void ballsSizeThree() throws Exception {
        Balls balls = new Balls();
        assertThat(balls.isSize(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4})
    @DisplayName("볼 사이즈 3개 예외 확인")
    public void sizeException(int size) throws Exception {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Ball(1));
        }

        assertThatThrownBy(() -> new Balls(result))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
