package baseball.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;
    private int ballCount;

    @BeforeEach
    void init() {
        computer = new Computer();
        ballCount = 3;
    }

    @DisplayName("임의의 수 생성기능 구현")
    @Test
    void 임의의_수_생성() {

        //given

        //when
        List<Integer> balls = computer.ready(ballCount);

        //then
        assertThat(balls).hasSize(ballCount);
        assertThat(balls).doesNotHaveDuplicates();

    }

}