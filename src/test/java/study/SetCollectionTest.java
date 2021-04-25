package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetCollectionTest {
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
    @DisplayName("Set 콜렉션의 사이즈 확인")
    public void confirm_sizeof_set_test() {
        int sizeOfTarget = 3;

        Assertions.assertThat(numbers)
                  .hasSize(sizeOfTarget);
    }

    @ParameterizedTest
    @DisplayName("Set 콜렉션내 item 확인")
    @ValueSource(ints = {1, 2, 3})
    public void confirm_item_of_set_test(int input) {
        Assertions.assertThat(numbers).contains(input);
    }

}
