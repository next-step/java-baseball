import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StrikeCalculatorTest {

    private StrikeCalculator strikeCalculator;
    private String test123;

    @BeforeEach
    public void beforeSet() {
        strikeCalculator = new StrikeCalculator(BaseballGame.DEFAULT_LEN);
        test123 = "123";
    }

    private void assertStrikeWhenFirstIsFixed(String generated, String[] inputs, int strikesCnt) {
        for (String input : inputs)
            Assertions.assertEquals(strikeCalculator.getStrikesCnt(generated, input), strikesCnt);
    }

    @Test
    public void isCountedOneStrike(){

        String[] inputs ={"174", "825", "573"};
        assertStrikeWhenFirstIsFixed(test123, inputs, 1);
    }

    @Test
    public void isCountedTwoStrike(){

        String[] inputs = {"124", "823", "173"};
        assertStrikeWhenFirstIsFixed(test123, inputs, 2);
    }

}
