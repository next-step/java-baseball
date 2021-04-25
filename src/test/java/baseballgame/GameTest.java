package baseballgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {
    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    @BeforeEach
    void beforeEach() {
        computerNumbers = new ArrayList<>();
        userNumbers = new ArrayList<>();
    }

    @ParameterizedTest
    @DisplayName("모두 맞추지 못한 경우")
    @CsvSource(value = {"1,2", "3,4", "5,6"}, delimiterString = ",")
    void checkNothing(int computer, int user) {
        //given
        //when
        computerNumbers.add(computer);
        userNumbers.add(user);
        //then
        assertNotEquals((int) computerNumbers.get(0), user);
        assertFalse(userNumbers.contains(computer));
    }

    @ParameterizedTest
    @DisplayName("스트라이크인 경우")
    @CsvSource(value = {"1,1", "2,2", "3,3"}, delimiterString = ",")
    void checkStrikeCount(int computer, int user) {
        //given
        //when
        computerNumbers.add(computer);
        userNumbers.add(user);
        //then
        assertEquals(computerNumbers.get(0), userNumbers.get(0));
    }

    @Test
    @DisplayName("볼인 경우")
    void checkStrikeAndBall() {
        //given
        int ball = 0;
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(3, 1, 2);
        //when
        ball += computerNumbers.contains(userNumbers.get(0)) ? 1 : 0;
        ball += computerNumbers.contains(userNumbers.get(1)) ? 1 : 0;
        ball += computerNumbers.contains(userNumbers.get(2)) ? 1 : 0;
        //then
        assertEquals(3, ball);
    }
}