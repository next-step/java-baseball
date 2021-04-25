package domain.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StrikeCounterTest {
    private List<Integer> answer;

    @BeforeEach
    void generate_answer() {
        answer = new ArrayList<>();
        answer.add(1);
        answer.add(6);
        answer.add(7);
    }

    @Test
    @DisplayName("스트라이크 카운트가 알맞게 나오는지")
    void get_strike_count() {

        // given
        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(6);
        input.add(7);
        StrikeCounter strikeCounter = StrikeCounter.of(answer);
        int expected = 2;
        int result;

        // when
        result = strikeCounter.getStrikeCount(input);

        // then
        assertEquals(expected, result);
    }
}