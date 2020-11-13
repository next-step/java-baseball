package com.jyjeong.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberCheckTest {
    private NumberCheck numberCheck = new NumberCheck();
    private Computer computer = new Computer();

    @Test
    @DisplayName("3자리 숫자의 중복여부 확인 테스트")
    void uniqueCheck() {
        //given
        int[] trueNum = {8,2,3};
        int[] falseNum = {8,2,2};

        //when
        boolean trueCheck = numberCheck.uniqueCheck(trueNum);
        boolean falseCheck = numberCheck.uniqueCheck(falseNum);

        //then
        assertThat(trueCheck).isTrue();
        assertThat(falseCheck).isFalse();
    }


    @Test
    @DisplayName("숫자 여부 확인 테스트")
    void numberCheck(){
        //given
        String trueData = "123";
        String falseData = "abc";

        //when
        boolean trueCheck = numberCheck.numberCheck(trueData);
        boolean falseCheck = numberCheck.numberCheck(falseData);

        //then
        assertThat(trueCheck).isTrue();
        assertThat(falseCheck).isFalse();
    }

    @Test
    @DisplayName("숫자의 길이 확인 테스트")
    void lengthCheck(){
        //given
        String trueData = "123";
        String falseData = "1579";

        //when
        boolean trueCheck = numberCheck.lengthCheck(trueData);
        boolean falseCheck = numberCheck.lengthCheck(falseData);

        //then
        assertThat(trueCheck).isTrue();
        assertThat(falseCheck).isFalse();
    }
}