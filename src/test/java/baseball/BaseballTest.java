package baseball;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    String answer = "";
    Random random = new Random();

    @Test
    void main() {
    }

    @Test
    void initGame() {

        random.setSeed(System.currentTimeMillis());

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while(set.size() != 3) {
            set.add(random.nextInt(9) + 1);
        }

        for (int number : set) {
            answer += number;
        }

        assertEquals(3, set.size());
        assertEquals(3, answer.length());
    }
}