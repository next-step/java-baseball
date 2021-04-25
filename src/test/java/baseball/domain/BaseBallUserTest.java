package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallUserTest {

    @Test
    @DisplayName("사용자가 초기 생성한 숫자길이 체크")
    void userCreateNumLenCheck(){
        //given
        String[] num = "1234".split("");

        //when

        //then
        org.junit.jupiter.api.Assertions.assertNotEquals(3, num.length);
    }

    @Test
    @DisplayName("사용자가 초기 생성한 숫자유효성(1~9) 체크")
    void userCreateNumInputCheck(){
        //given
        String[] num = "dka".split("");

        //when

        //then
        for(int i=0; i<num.length; i++){
            org.junit.jupiter.api.Assertions.assertFalse(num[i].matches("^[1-9]+$"));
        }
    }

    @Test
    @DisplayName("사용자가 초기 생성한 숫자 중복체크")
    void userCreateNumDupCheck(){
        //given
        String[] num = "111".split("");

        //when
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(num[i]);
        }

        //then
        Assertions.assertThat(arr[0]).isEqualTo(arr[1]);
        Assertions.assertThat(arr[0]).isEqualTo(arr[2]);
        Assertions.assertThat(arr[1]).isEqualTo(arr[2]);
    }

}