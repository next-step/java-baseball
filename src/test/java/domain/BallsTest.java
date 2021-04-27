package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("숫자볼 모음")
public class BallsTest {

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

    @ParameterizedTest
    @ValueSource(strings = {"112", "121", "998"})
    @DisplayName("중복번호 예외 확인")
    public void duplicateException(String inputText) throws Exception {
        assertThatThrownBy(() -> new Balls(inputText))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
