package baseballgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("범위 밖의 랜덤 숫자 생성")
    void generateInvalidRandNumber() {
        //given
        Random random = new Random();
        //when
        int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;
        //then
        assertFalse(randNumber >= 10);
    }

    @Test
    @DisplayName("랜덤 숫자 생성")
    void generateValidRandNumber() {
        //given
        Random random = new Random();
        //when
        int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;
        //then
        assertNotEquals(0, randNumber);
        assertTrue(randNumber <= Const.MAX_NUMBER);
    }

    @RepeatedTest(100)
    @DisplayName("랜덤 숫자 100번 생성")
    void generateRandNumbers() {
        //given
        Random random = new Random();
        //when
        int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;
        //then
        assertTrue(randNumber >= Const.MIN_NUMBER);
        assertTrue(randNumber <= Const.MAX_NUMBER);
    }

    @Test
    @DisplayName("랜덤 숫자 3개 생성")
    void checkRandNumberCount() {
        //given
        Computer computer = new Computer();
        //when
        computer.selectNumber();
        //then
        assertEquals(Const.NUMBER_COUNT, computer.getNumbers().size());
    }

    @RepeatedTest(100)
    @DisplayName("중복 숫자 만들어 지지 않는지 100번 테스트")
    void checkDuplicatedNumber() {
        //given
        Computer computer = new Computer();
        computer.selectNumber();
        //when
        List<Integer> randNumbers = computer.getNumbers();
        //then
        assertNotEquals(randNumbers.get(0), randNumbers.get(1));
        assertNotEquals(randNumbers.get(1), randNumbers.get(2));
        assertNotEquals(randNumbers.get(0), randNumbers.get(2));
    }
}