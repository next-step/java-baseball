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

    @Test
    @DisplayName("사용자가 선택한 숫자와 컴퓨터가 고른 숫자 비교")
    public void guessNumberResultTest(){
        int playerInputNumber = 523;
        int computerInputNumber = 123;
        ComputerImplement computer = new ComputerImplement();
        PlayerImplement player = new PlayerImplement();

        computer.setSaveNumber(computerInputNumber);
        computer.saveComputerNumberArr(computerInputNumber);

        computer.guessNumberResult(playerInputNumber);
        int[] resultArr = new int[2];
        resultArr[0] = computer.getStrikeCnt();
        resultArr[1] = computer.getBallCnt();
        assertThat(resultArr).as("야구게임 결과 확인").isEqualTo(new int[]{2,0});
    }

}