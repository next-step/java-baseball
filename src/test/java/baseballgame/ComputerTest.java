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
        final int minNumber = 1;
        final int maxNumber = 9;
        Random random = new Random();
        int randNumber = random.nextInt(maxNumber) + minNumber;

        assertFalse(randNumber >= 10);
    }

    @Test
    @DisplayName("랜덤 숫자 생성")
    void generateValidRandNumber() {
        final int minNumber = 1;
        final int maxNumber = 9;
        Random random = new Random();
        int randNumber = random.nextInt(maxNumber) + minNumber;

        assertNotEquals(0, randNumber);
        assertTrue(randNumber <= maxNumber);
    }

    @Test
    @DisplayName("랜덤 숫자 100번 생성")
    void generateRandNumbers() {
        final int minNumber = 1;
        final int maxNumber = 9;
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randNumber = random.nextInt(maxNumber) + minNumber;
            assertTrue(randNumber >= minNumber);
            assertTrue(randNumber <= maxNumber);
        }
    }

    @Test
    @DisplayName("랜덤 숫자 3개 생성")
    void checkRandNumberCount() {
        final int minNumber = 1;
        final int maxNumber = 9;
        final int count = 3;
        List<Integer> randNumbers = new ArrayList<>();
        Random random = new Random();

        while (randNumbers.size() < count) {
            int randNumber = random.nextInt(maxNumber) + minNumber;
            randNumbers.add(randNumber);
        }

        assertEquals(count, randNumbers.size());
    }

    @Test
    @DisplayName("중복 숫자 만들어 지지 않는지 100번 테스트")
    void checkDuplicatedNumber() {
        final int minNumber = 1;
        final int maxNumber = 9;
        final int count = 3;
        List<Integer> randNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            while (randNumbers.size() < count) {
                int randNumber = random.nextInt(maxNumber) + minNumber;

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