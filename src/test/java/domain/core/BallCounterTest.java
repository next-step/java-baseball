package domain.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallCounterTest {
    private List<Integer> answer;

    @BeforeEach
    void generate_answer() {
        answer = new ArrayList<>();
        answer.add(1);
        answer.add(6);
        answer.add(7);
    }

    @Test
    @DisplayName("볼 카운트가 알맞게 나오는지")
    void get_ball_count(){

        // given
        List<Integer> input = new ArrayList<>();
        input.add(6);
        input.add(7);
        input.add(1);
        BallCounter ballCounter = BallCounter.of(answer);
        int expected = 3;
        int result;

        // when
        result = ballCounter.getBallCount(input);

        // then
        assertEquals(expected, result);
    }
}