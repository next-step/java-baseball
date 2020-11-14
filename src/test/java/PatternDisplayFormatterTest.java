import model.PatternResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class PatternDisplayFormatterTest {
    @Test
    @DisplayName("1개의 스트라이크가 있으면, '1 스트라이크' 리턴")
    void case1() {
        PatternResult patternResult = new PatternResult(1, 0);
    }

    @Test
    @DisplayName("2개의 스트라이크가 있으면, '2 스트라이크' 리턴")
    void case2() {
        PatternResult patternResult = new PatternResult(2, 0);
    }

    @Test
    @DisplayName("3개의 스트라이크가 있으면, '3 스트라이크' 리턴")
    void case3() {
        PatternResult patternResult = new PatternResult(3, 0);
    }

    @Test
    @DisplayName("1개의 볼이 있으면, '1 볼' 리턴")
    void case4() {
        PatternResult patternResult = new PatternResult(0, 1);
    }

    @Test
    @DisplayName("2개의 볼이 있으면, '2 볼' 리턴")
    void case5() {
        PatternResult patternResult = new PatternResult(0, 2);
    }

    @Test
    @DisplayName("3개의 볼이 있으면, '3 볼' 리턴")
    void case6() {
        PatternResult patternResult = new PatternResult(0, 3);
    }

    @Test
    @DisplayName("1개의 스트라이크 및 2개의 볼이 있으면, '2 스트라이크, 1 볼' 리턴")
    void case7() {
        PatternResult patternResult = new PatternResult(0, 3);
    }

    @Test
    @DisplayName("스트라이크 또는 볼이 전혀 없으면, '낫싱' 리턴")
    void case8() {
        PatternResult patternResult = new PatternResult(0, 0);
    }
}
