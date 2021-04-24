import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
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

}