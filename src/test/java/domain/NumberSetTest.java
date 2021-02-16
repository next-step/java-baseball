package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberSetTest {

    private NumberSet numberSet;

    @BeforeEach
    void setUp() {
        numberSet = new NumberSet();
    }

    @Test
    void getNumbers() {
        numberSet.addNumbers(new Number(1));
        numberSet.addNumbers(new Number(2));
        numberSet.addNumbers(new Number(3));
        numberSet.addNumbers(new Number(4));
        assertThat(numberSet.getNumbers().size()).isEqualTo(4);
    }

    @Test
    void addNumbers() {
        numberSet.addNumbers(new Number(5));
        assertThat(numberSet.getNumbers().get(0).getNumber()).isEqualTo(5);
    }
}