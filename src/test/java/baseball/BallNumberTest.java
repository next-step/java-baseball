package baseball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BallNumberTest {

    @Test
    @DisplayName("컴퓨터에서 3자리 임의의 수 생성에 대한 테스트")
    void randomBallNumberCheck() {
        BallNumberRandom computerNumber = new BallNumberRandom();
        assertThat(computerNumber.getBallNumber().size()).isEqualTo(3);
    }
}
