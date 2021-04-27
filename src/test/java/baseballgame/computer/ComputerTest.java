package baseballgame.computer;

import baseballgame.constant.BallCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터는 랜덤하게 정해진 개수의 공을 생성합니다.")
    void createComputer() {
        Computer computer = Computer.createComputer();
        assertThat(computer.getBalls().size()).isEqualTo(BallCount.COUNT);
    }
}