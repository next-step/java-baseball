package freecourse1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    RandomNumber randomNumber;
    int[] actualArray;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    public void isNullTest(){
        assertThat(randomNumber).isNotNull();
    }

    @Test
    public void isNumberValidationTest() {
        int[] expectedArray;

        randomNumber.make();
        expectedArray = randomNumber.getNumbers();

        assertThat(expectedArray).hasSize(3);

        for (int i=0; i<3; i++) {
            assertThat(expectedArray[i]).isBetween(1,9);
        }
    }

}
