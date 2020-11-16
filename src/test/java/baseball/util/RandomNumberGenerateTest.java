package baseball.util;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGenerateTest {
    @RepeatedTest(100)
    void generateTest() {
        assertThat(RandomNumberGenerate.generate(3))
                .isBetween(100, 999);
    }
}
