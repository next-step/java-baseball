package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallGameUtilTest {


    @DisplayName("숫자 비교 : 1스트라이크 2볼 ")
    @Test
    public void judge1s2b(){
        BaseBallGameUtil baseBallGameUtil3 = new BaseBallGameUtil();

        int[] computerNumbers = {1,2,3};

        int[] userNumbers = {1,3,2};

        int strike = 0;
        int ball = 0;


        for (int i =0; i<3; i++) {

            strike = baseBallGameUtil3.judgeStrike(computerNumbers[i], userNumbers[i]);
            ball = baseBallGameUtil3.judgeBall(computerNumbers, userNumbers[i], i);
        }


        assertThat(strike).isEqualTo(1);
        assertThat(ball).isEqualTo(2);

    }

    @DisplayName("3스트라이크 일때 결과값 확인 ")
    @Test
    public void judge3s(){
        BaseBallGameUtil baseBallGameUtil2 = new BaseBallGameUtil();

        int[] computerNumbers = {1,2,3};

        int[] userNumbers = {1,2,3};

        boolean judgeResult = true;

        for (int i =0; i<3; i++) {
            judgeResult =  baseBallGameUtil2.judgeStrikeBall(computerNumbers, userNumbers);
        }

        assertThat(judgeResult).isFalse();

    }





}
