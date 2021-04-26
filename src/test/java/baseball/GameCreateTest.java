package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class GameCreateTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(5);
        numbers.add(5);
        numbers.add(3);
        numbers.add(3);
        numbers.add(8);
        numbers.add(8);
    }

    @Test
    void createNumbersNotDuplication() {
        assertEquals(numbers.size(), 3);
    }

    @Test
    void createRandomNumbersOneToNine() {
        Random random = new Random();
        int min = 10;
        int max = 0;
        for (int i = 0; i < 1000; i++) {
            int number = random.nextInt(9) + 1;

            if (min > number) {
                min = number;
            }

            if (max < number) {
                max = number;
            }
        }

        assertEquals(9, max);
        assertEquals(1, min);
    }

    @Test
    void createRandomNumbersNotDuplication() {
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();

        while (set.size() < 3) {
            set.add(random.nextInt(9) + 1);
        }

        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        
        assertEquals(3, list.size());
    }
}
