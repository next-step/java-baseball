package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerImplementTest {

    @Test
    @DisplayName("3개의 랜덤 숫자를 고르는 테스트")
    public void selectGameBallTest(){
        ComputerImplement computer = new ComputerImplement();
        computer.selectGameBall();

        int[] selectThreeBall = computer.getSaveNumberArr();

        assertThat(selectThreeBall).as("램덤숫자 3가지를 선택하는 테스트").hasSize(3);
    }

}