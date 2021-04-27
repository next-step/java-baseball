import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    /*
        랜덤 숫자를 제대로 생성되는지 테스트
     */
    @Test
    public void createNumberArray() {
        Baseball baseball = new Baseball();
        int[] balls = baseball.createNumberArray();
        int length = balls.length;

        assertThat(length).isEqualTo(3);
    }
}
