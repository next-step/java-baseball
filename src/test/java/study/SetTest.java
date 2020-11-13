package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set number;

    @BeforeEach
    void setUp() {
        number = new HashSet();
        number.add(1);
        number.add(1);
        number.add(2);
        number.add(3);
    }

    @Test
    void size() {
        assertThat(number).hasSize(3);
    }
}
