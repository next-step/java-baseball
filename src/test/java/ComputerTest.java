import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    @DisplayName("3자리 수가 제대로 제작되는지 확인")
    public void numberComputerFormatCreateTest(){
        Random random = new Random();
        assertThat(Integer.toString(random.nextInt(9) + 1 * 100 + random.nextInt(10) * 10 + random.nextInt(10)).length()).isEqualTo(3);
    }
}
