package com.vjerksen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class BaseballGameTest {

    // given
    private BaseballGame baseballGame = new BaseballGame();
    private RandomNumber randomNumber = new RandomNumber();
    private final int STRIKE_NUM = 3;
    private String randomNum = "135";
    private String inputNum = "135";

/*

    * 입력받는 부분이 있어 주석 처리

    @DisplayName(value = "야구게임 정상 진행 확인")
    @Test
    public void playGameTest() {
        // when
        boolean playGame = baseballGame.playGame();

        // then
        assertThat(playGame).isTrue();
    }
 */
    @DisplayName(value = "입력된 숫자의 상태 확인")
    @Test
    public void chkConditionTest() {
        // when
        boolean chkConditionTest = baseballGame.chkCondition(inputNum, randomNum);

        // then
        assertThat(chkConditionTest).isTrue();
    }

    @DisplayName(value = "스트라이크 여부 확인에 필요한 상태 확인")
    @Test
    public void compareToStirkeTest() {
        // when
        char compareValue1 = '1';
        char compareValue2 = '2';

        int compareToStrike = baseballGame.compareToStirke(compareValue1, compareValue2);

        // then
        assertThat(compareToStrike).isEqualTo(0);
    }

    @DisplayName(value = "볼 여부 확인에 필요한 상태 확인")
    @Test
    public void compareToBallTest() {
        // given
        Set<Character> testSet = new HashSet<>();
        testSet.add('1');
        testSet.add('2');
        testSet.add('3');

        char testChar = '1';

        // when
        int compareToBall = baseballGame.compareToBall(testSet, testChar);

        // then
        assertThat(compareToBall).isEqualTo(1);
    }

}