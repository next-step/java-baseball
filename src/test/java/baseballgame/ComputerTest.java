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
}