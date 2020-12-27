package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MySetTest {
    private MySet set;

    @BeforeEach
    public void setUp() {
        set = new MySet();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void sizeWithDuplicateElement() {
        assertThat(set.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void integersExist(int value, boolean expected) {
        assertThat(set.contains(value)).isEqualTo(expected);
    }
}
