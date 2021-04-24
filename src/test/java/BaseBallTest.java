import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallTest {

    private BaseBall bbs;

    @BeforeEach
    void setUp() {
        bbs = new BaseBall();
    }

    @Test
    void unique3DigitStringTest() {
        String goal = bbs.unique3DigitString();
        String[] splitGoal = goal.split("");
        Set<String> uniqueGoal = new HashSet<>(Arrays.asList(splitGoal));

        assertThat(goal.length()).isEqualTo(3);
        assertThat(uniqueGoal.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "123:123:3:0",
            "123:231:0:3",
            "123:456:0:0",
            "123:156:1:0",
            "123:125:2:0",
            "123:137:1:1"
    }, delimiter = ':')
    void judgeBaseBall(String goal, String source, Integer s, Integer b) {
        Map<String, Integer> resultMap = bbs.judgeBaseBall(goal, source);
        Integer strike = resultMap.get("STRIKE");
        Integer ball = resultMap.get("BALL");

        assertThat(strike).isEqualTo(s);
        assertThat(ball).isEqualTo(b);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:true"}, delimiter = ':')
    void judgeFinishTest(Integer strike, boolean expected) {
        boolean actual = bbs.judgeFinish(strike);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void resetGoal() {
        String goal = bbs.unique3DigitString();
        String restartGoal = bbs.resetGoal(true, goal);
        assertThat(goal).isNotEqualTo(restartGoal);

        String notRestartGoal = bbs.resetGoal(false, goal);
        assertThat(goal).isEqualTo(notRestartGoal);
    }

}