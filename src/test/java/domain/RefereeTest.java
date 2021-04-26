package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("심판")
public class RefereeTest {
    private NumberBalls randomBalls;
    private NumberBalls inputBalls;

    @BeforeEach
    public void setUp() {
        List<NumberBall> balls = new ArrayList<>();
        balls.add(new NumberBall(1));
        balls.add(new NumberBall(2));
        balls.add(new NumberBall(3));

        randomBalls = new NumberBalls(balls);
    }

    public void createInputBalls(String inputText) {
        List<NumberBall> result = new ArrayList<>();
        String[] split = inputText.split(",");
        for (int i = 0; i < split.length; i++) {
            result.add(new NumberBall(Integer.parseInt(split[i])));
        }
        inputBalls = new NumberBalls(result);
    }

    @Test
    @DisplayName("랜덤볼과 입력볼 사이즈 확인")
    public void isEqualSize() throws Exception {
        Assertions.assertThat(Referee.isSizeCompare(randomBalls, inputBalls)).isTrue();
    }
}
