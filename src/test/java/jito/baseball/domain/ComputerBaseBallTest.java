package jito.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerBaseBallTest {

    @Test
    @DisplayName("컴퓨터가 숫자를 선택한다.")
    public void makeNumbers() throws Exception {
        //given
        ComputerBaseBall computerBaseBall = new ComputerBaseBall();
        computerBaseBall.makeBaseBall();

        //when
        int[] computerNumbers = computerBaseBall.getComputerNumbers();

        //then
        assertThat(computerNumbers.length).isBetween(1, 9);
    }

    @Test
    @DisplayName("1 ~ 9 범위의 숫자들로 선택한다.")
    public void isOneToNineNumber() throws Exception {
        //given
        ComputerBaseBall computerBaseBall = new ComputerBaseBall();
        computerBaseBall.makeBaseBall();

        //when
        int[] computerNumbers = computerBaseBall.getComputerNumbers();

        //then
        for (int number : computerNumbers) {
            assertThat(number).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("3자리의 수로 구성한다.")
    public void isThreeDigits() throws Exception {
        //given
        ComputerBaseBall computerBaseBall = new ComputerBaseBall();
        computerBaseBall.makeBaseBall();

        //when
        int[] computerNumbers = computerBaseBall.getComputerNumbers();

        //then
        assertEquals(computerNumbers.length,3);
    }

    @Test
    @DisplayName("각 자릿수를 서로 다른 숫자로 구성한다.")
    public void isNotDuplicate() throws Exception {
        //given
        ComputerBaseBall computerBaseBall = new ComputerBaseBall();
        computerBaseBall.makeBaseBall();

        //when
        int[] computerNumbers = computerBaseBall.getComputerNumbers();

        //then
        assertNotEquals(computerNumbers[0], computerNumbers[1]);
        assertNotEquals(computerNumbers[0], computerNumbers[2]);
        assertNotEquals(computerNumbers[1], computerNumbers[2]);
    }
}