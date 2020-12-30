import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void getSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input){
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:false"}, delimiter = ':')
    void contains2(int input, boolean expected){
        boolean arr[] = {true, true, true, false};
        boolean val = arr[input];
        assertEquals(arr[input], expected);
    }


}
