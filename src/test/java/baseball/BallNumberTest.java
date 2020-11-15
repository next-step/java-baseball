package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BallNumberTest {

    @DisplayName("컴퓨터(딜러)가 생성하는 랜덤 3 숫자를 확인한다.")
    @Test
    void randomBallNumberCheck() {
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy());
        assertThat(dealersNumber.getBallNumber().size()).isEqualTo(3);
    }

}
