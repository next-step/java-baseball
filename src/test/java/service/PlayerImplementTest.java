package service;

import interfaces.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerImplementTest {

    @Test
    @DisplayName("100의 자리 숫자를 입력받아서 각각의 자릿수 숫자를 구하는 테스트")
    public void saveInputNumberArrTest(){
        int inputNum = 624;
        PlayerImplement player = new PlayerImplement();

        player.saveInputNumberArr(inputNum);
        int[] inputNumArr = player.getSaveInputNumArr();

        assertThat(inputNumArr).containsExactly(6,2,4);

    }


    @Test
    @DisplayName("숫자 입력하는 테스트")
    public void inputGuessableNumberTest() throws IOException {
        PlayerImplement player = new PlayerImplement();

        player.inputGuessableNumber();
        int inputNum = player.getInputNum();
        assertThat(inputNum).as("숫자 입력받는 테스트").isPositive().isNotZero();


    }

}