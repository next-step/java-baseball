package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberTest {

    private Number number;

    @BeforeEach
    void setUp() {
        number = new Number(5);
    }

    @Test
    void getNumber() {
        number = new Number(5);
        System.out.println(number);
        assertThat(number.getNumber()).isEqualTo(5);
    }
}