package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerBallNumberTest {

    @Test
    @DisplayName("컴퓨터 야구볼 생성 테스트")
    void computer_ball_number_test() {

        // given
        ComputerBallNumber computerBallNumber = new ComputerBallNumber(new RandomNumberGenerator());

        // when
        BaseBallNumbers computerBallNumbers = computerBallNumber.getBallNumbers();

        // then
        assertThat(computerBallNumbers.getBaseBallNumbers().size()).isEqualTo(3);
    }
}
