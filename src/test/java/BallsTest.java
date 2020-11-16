import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("컴퓨터 및 사용자 공 클래스 테스트")
class BallsTest {

    @Test
    @DisplayName("Balls1과 Balls2를 비교하여 결과가 제대로 나오는지 테스트")
    void compareTest() {
        Balls balls1 = new Balls(Arrays.asList(1,2,3));
        Balls balls2 = new Balls(Arrays.asList(1,3,2));

        String expected = "1 스트라이크 2 볼";

        Score score = balls1.compare(balls2);

        assertThat(score.calculateScore()).isEqualTo(expected);
    }
}