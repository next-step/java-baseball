import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {

    static BaseBallGame bbg;

    @BeforeAll
    static void setup() {
        bbg = new BaseBallGame();
        bbg.generateNumber();
    }

    @Test
    void generateBaseBallNumber() {
        // int[] range = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println("Generated Numbers :" +Arrays.toString(bbg.generatedArray));

        // https://www.baeldung.com/introduction-to-assertj
        assertThat(bbg.generatedArray)
                .hasSize(3)
                .doesNotHaveDuplicates();
    }


}