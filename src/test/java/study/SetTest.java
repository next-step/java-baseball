package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void testSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
        // assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testSetContains(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testIsSetContains(int number) {
        assertEquals(true, numbers.contains(number));
    }

}
