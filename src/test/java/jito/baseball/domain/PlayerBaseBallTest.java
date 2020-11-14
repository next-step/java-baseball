package jito.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerBaseBallTest {

    @Test
    @DisplayName("플레이어의 숫자를 입력 받는다.")
    public void makeNumbers() throws Exception {
        //given
        String input = "356";
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(input);

        //when
        int[] playerNumbers = playerBaseBall.getPlayerNumbers();

        //then
        assertThat(playerNumbers.length).isBetween(1, 9);
    }

    @Test
    @DisplayName("1 ~ 9 범위의 숫자들로 선택한다.")
    public void isOneToNineNumber() throws Exception {
        //given
        String input = "573";
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(input);

        //when
        int[] playerNumbers = playerBaseBall.getPlayerNumbers();

        //then
        for (int number : playerNumbers) {
            assertThat(number).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("3자리의 수로 구성한다.")
    public void isThreeDigits() throws Exception {
        //given
        String input = "375";
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(input);

        //when
        int[] playerNumbers = playerBaseBall.getPlayerNumbers();

        //then
        assertEquals(playerNumbers.length,3);
    }

    @Test
    @DisplayName("각 자릿수를 서로 다른 숫자로 구성한다. (서로 다른 수)")
    public void isNotDuplicate() throws Exception {
        //given
        String input = "867";
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(input);

        //when
        int[] playerNumbers = playerBaseBall.getPlayerNumbers();

        //then
        assertNotEquals(playerNumbers[0], playerNumbers[1]);
        assertNotEquals(playerNumbers[0], playerNumbers[2]);
        assertNotEquals(playerNumbers[1], playerNumbers[2]);
    }
}