import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size를 확인한다.")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(4);
    }


    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3"})
    void containsOneTwoThree(int i) {
        assertThat(numbers.contains(i)).isTrue();
    }
}