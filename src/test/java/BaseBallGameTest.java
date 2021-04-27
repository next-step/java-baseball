import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseBallGameTest {

    static BaseBallGame bbg;

    @BeforeAll
    static void setup() {
        bbg = new BaseBallGame();
        bbg.generateNumber();
    }

    @Test
    @DisplayName("컴퓨터가 생성하는 숫자 확인")
    void generate_baseBall_number() {
        // int[] range = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println("Generated Numbers :" +Arrays.toString(bbg.generatedArray));

        // https://www.baeldung.com/introduction-to-assertj
        assertThat(bbg.generatedArray)
                .hasSize(3)
                .doesNotHaveDuplicates();
    }


}