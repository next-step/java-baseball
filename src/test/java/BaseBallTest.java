import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"123:true", "1234:false", "ded:false", "ddd:false"}, delimiter = ':')
    void checkUnique3DigitStringTest(String target, boolean expected) {
        boolean actual = bbs.checkUnique3DigitString(target);

        assertThat(actual).isEqualTo(expected);
    }
}