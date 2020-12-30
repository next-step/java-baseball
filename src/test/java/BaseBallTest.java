import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BaseBallTest {

    @Test
    @DisplayName("스트라이크, 볼 계산 테스트")
    public void Baseball() {
        // case 1
        BaseBall answer1 = new BaseBall();
        answer1.setAnswer(1, 2, 3);
        Respond result1 = answer1.calculate(Arrays.asList(1, 2, 3));
        assertThat(result1.getStrikes()).isEqualTo(3);
        assertThat(result1.getBalls()).isEqualTo(0);

        // case 2
        BaseBall answer2 = new BaseBall();
        answer2.setAnswer(7, 8, 6);
        Respond result2 = answer2.calculate(Arrays.asList(6, 7, 8));
        assertThat(result2.getStrikes()).isEqualTo(0);
        assertThat(result2.getBalls()).isEqualTo(3);

        // case 3
        BaseBall answer3 = new BaseBall();
        answer3.setAnswer(3, 6, 9);
        Respond result3 = answer3.calculate(Arrays.asList(9, 6, 3));
        assertThat(result3.getStrikes()).isEqualTo(1);
        assertThat(result3.getBalls()).isEqualTo(2);

        // case 4
        BaseBall answer4 = new BaseBall();
        answer4.setAnswer(3, 6, 9);
        Respond result4 = answer4.calculate(Arrays.asList(2, 4, 8));
        assertThat(result4.toString()).isEqualTo("낫싱");
    }

}
