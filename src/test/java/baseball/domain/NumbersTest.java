package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void getNumbers() {
        Numbers numbers = new Numbers("123");
        List<Integer> expected = Arrays.asList(1,2,3);
        for(int i=0; i<expected.size(); i++){
            assertThat(numbers.getNumbers().get(i)).isEqualTo(expected.get(i));
        }
    }
}