package khj.baseball.flow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowTest {
    Flow flow;

    @BeforeEach
    void setUp() {
        flow = new Flow(new MockGame());
    }

    @DisplayName("한번만 플레이 했을 경우")
    @Test
    void start() {
        play(1, "2");
    }

    @DisplayName("한번 더 플레이 했을 때 플레이 횟수가 2가 나오는 지 확인")
    @Test
    void startMorePlay() {
        play(2, "1\n2");
    }

    private void play(int expected, String input) {
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);

        flow.start();

        assertEquals(expected, flow.getPlayCount());
    }
}





