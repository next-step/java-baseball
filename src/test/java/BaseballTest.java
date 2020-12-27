import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class BaseballTest {
    @Test
    void generateBaseballNumbers_void_NumericWithLengthOf3(){
        for(int i=0; i<100; i++){
            String generated = Baseball.generateBaseballNumbers();
            assertThat(Baseball.isValidInput(generated)).as("Generated : " + generated).isEqualTo(true);
        }
    }
    @Test
    void isValidInput_LengthIsNot3_False(){
        assertThat(Baseball.isValidInput("12345")).isEqualTo(false);
        assertThat(Baseball.isValidInput("1234")).isEqualTo(false);
        assertThat(Baseball.isValidInput("12")).isEqualTo(false);
        assertThat(Baseball.isValidInput("1")).isEqualTo(false);
    }
    @Test
    void isValidInput_IncludesNonNumeric_False(){
        assertThat(Baseball.isValidInput("abc")).isEqualTo(false);
        assertThat(Baseball.isValidInput("1.2")).isEqualTo(false);
    }
    @Test
    void isValidInput_LengthIs3Numeric_True() {
        assertThat(Baseball.isValidInput("123")).isEqualTo(true);
    }

    @Test
    void countStrikes_0to3_0to3(){
        assertThat(Baseball.countStrikes("123", "234")).isEqualTo(0);
        assertThat(Baseball.countStrikes("123", "132")).isEqualTo(1);
        assertThat(Baseball.countStrikes("123", "124")).isEqualTo(2);
        assertThat(Baseball.countStrikes("123", "123")).isEqualTo(3);
    }

    @Test
    void countBalls_0to3_0to3(){
        assertThat(Baseball.countBalls("123", "456")).isEqualTo(0);
        assertThat(Baseball.countBalls("123", "356")).isEqualTo(1);
        assertThat(Baseball.countBalls("123", "631")).isEqualTo(2);
        assertThat(Baseball.countBalls("123", "312")).isEqualTo(3);
    }
}
