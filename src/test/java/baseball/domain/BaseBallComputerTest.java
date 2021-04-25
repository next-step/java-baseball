package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallComputerTest {

    @Test
    @DisplayName("컴퓨터가 초기 숫자 생성")
    void computerCreateNum(){
        //given
        BaseBallComputer baseBallComputer = new BaseBallComputer();
        baseBallComputer.computerCreateNum();

        //when
        String num = baseBallComputer.getComputerCreateNum();

        //then
        Assertions.assertThat(num).isNotEmpty();
    }

    @Test
    @DisplayName("컴퓨터가 초기 생성한 숫자길이 체크")
    void computerCreateNumLenCheck(){
        //given
        BaseBallComputer baseBallComputer = new BaseBallComputer();
        baseBallComputer.computerCreateNum();

        //when
        String num = baseBallComputer.getComputerCreateNum();

        //then
        org.junit.jupiter.api.Assertions.assertEquals(3, num.length());
    }

    @Test
    @DisplayName("컴퓨터가 초기 생성한 숫자유효성(1~9) 체크")
    void computerCreateNumInputCheck(){
        //given
        BaseBallComputer baseBallComputer = new BaseBallComputer();
        baseBallComputer.computerCreateNum();

        //when
        String[] num = baseBallComputer.getComputerCreateNum().split("");
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(num[i]);
        }

        //then
        for(int i=0; i<3; i++){
            Assertions.assertThat(arr[i]).isBetween(1,9);
        }
    }

    @Test
    @DisplayName("컴퓨터가 초기 생성한 숫자 중복체크")
    void computerCreateNumDupCheck(){
        //given
        BaseBallComputer baseBallComputer = new BaseBallComputer();
        baseBallComputer.computerCreateNum();

        //when
        String[] num = baseBallComputer.getComputerCreateNum().split("");
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(num[i]);
        }

        //then
        Assertions.assertThat(arr[0]).isNotEqualTo(arr[1]);
        Assertions.assertThat(arr[0]).isNotEqualTo(arr[2]);
        Assertions.assertThat(arr[1]).isNotEqualTo(arr[2]);
    }

    @Test
    @DisplayName("입력한 숫자의 위치와 값이 모두 일치하면 True")
    void True(){
        //given
        BaseBallComputer baseBallComputer = new BaseBallComputer();
        String com = "257";
        String user = "257";

        //when
        boolean check = baseBallComputer.game(com, user);

        //then
        Assertions.assertThat(check).isFalse();
    }

    @Test
    @DisplayName("입력한 숫자의 위치와 값이 하나라도 틀리면 False")
    void False(){
        //given
        BaseBallComputer baseBallComputer = new BaseBallComputer();
        String com = "257";
        String user = "252";

        //when
        boolean check = baseBallComputer.game(com, user);

        //then
        Assertions.assertThat(check).isTrue();

    }
}