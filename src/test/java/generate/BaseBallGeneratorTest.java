package generate;

import baseball.generate.BaseBallGenerator;
import baseball.generate.BaseBallNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGeneratorTest {

    @Test
    @DisplayName("생성되는 값은 3자리의 값을 갖는지 확인한다.")
    public void test_have_three_values() {
        BaseBallGenerator generate = new BaseBallNumberGenerator();
        int[] actual = generate.generate();
        assertThat(actual.length).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 3자리의 수는 각각 틀려야 한다.")
    public void test_different_value3() {
        BaseBallGenerator generate = new BaseBallNumberGenerator();
        int[] actual = generate.generate();

        assertThat(actual[0]).isNotEqualTo(actual[1]);
        assertThat(actual[0]).isNotEqualTo(actual[2]);
        assertThat(actual[1]).isNotEqualTo(actual[2]);
    }
}
