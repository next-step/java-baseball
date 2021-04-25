package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("게임이 생성과 동시에 Ball이 생성된다.")
    public void 게임이_생성과_동시에_Ball이_생성된다() {
        AtomicBoolean isGenerateCalled = new AtomicBoolean(false);

        new Game((size) -> {
            isGenerateCalled.set(true);

            List<Ball> balls = new ArrayList<>();
            for(int i = 0; i<size; i++) {
                balls.add(Ball.of(Ball.MINIMUM_NUMBER + i));
            }

            return new Balls(balls);
        });

        assertThat(isGenerateCalled.get())
                .isTrue();
    }
}
