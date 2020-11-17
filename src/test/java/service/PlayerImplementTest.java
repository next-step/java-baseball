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
    @DisplayName("100의 자리 숫자를 입력 받아서 각각의 자릿수 숫자를 구하는 테스트")
    public void saveInputNumberArrTest(){
        int inputNum = 624;
        PlayerImplement player = new PlayerImplement();

        player.saveInputNumberArr(inputNum);
        int[] inputNumArr = player.getSaveInputNumArr();

        assertThat(inputNumArr).containsExactly(6,2,4);

    }




}