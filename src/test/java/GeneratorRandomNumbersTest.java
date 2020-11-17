import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.GeneratorRandomNumbers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorRandomNumbersTest {


    @DisplayName("성공:1부터9까지서로다른수로이루어진3자리의수")
    @Test
    public void createRandomValueTest() {

        GeneratorRandomNumbers generatorRandomNumbers = new GeneratorRandomNumbers();

        int[] numbers = generatorRandomNumbers.generatorNumbers();

        for(Integer number : numbers){

            // 1~9까지
            assertThat(number).isBetween(1,9);

        }
        // 사이즈가 3자리
        assertThat(numbers.length).isEqualTo(3);


    }

}
