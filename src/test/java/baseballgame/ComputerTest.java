package baseballgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("범위 밖의 랜덤 숫자 생성")
    void generateInvalidRandNumber() {
        Random random = new Random();
        int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;

        assertFalse(randNumber >= 10);
    }

    @Test
    @DisplayName("랜덤 숫자 생성")
    void generateValidRandNumber() {
        Random random = new Random();
        int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;

        assertNotEquals(0, randNumber);
        assertTrue(randNumber <= Const.MAX_NUMBER);
    }

    @Test
    @DisplayName("랜덤 숫자 100번 생성")
    void generateRandNumbers() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;
            assertTrue(randNumber >= Const.MIN_NUMBER);
            assertTrue(randNumber <= Const.MAX_NUMBER);
        }
    }

    @Test
    @DisplayName("랜덤 숫자 3개 생성")
    void checkRandNumberCount() {
        List<Integer> randNumbers = new ArrayList<>();
        Random random = new Random();

        while (randNumbers.size() < Const.NUMBER_COUNT) {
            int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;

            randNumbers.add(randNumber);
        }

        assertEquals(Const.NUMBER_COUNT, randNumbers.size());
    }

    @Test
    @DisplayName("중복 숫자 만들어 지지 않는지 100번 테스트")
    void checkDuplicatedNumber() {
        List<Integer> randNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            while (randNumbers.size() < Const.NUMBER_COUNT) {
                int randNumber = random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;

                if (randNumbers.contains(randNumber)) {
                    continue;
                }
                randNumbers.add(randNumber);
            }
            int num1 = randNumbers.get(0);
            int num2 = randNumbers.get(1);
            int num3 = randNumbers.get(2);

            assertNotEquals(num1, num2);
            assertNotEquals(num2, num3);
            assertNotEquals(num1, num3);

            randNumbers.clear();
        }
    }
}