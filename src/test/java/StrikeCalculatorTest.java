import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StrikeCalculatorTest {

    private StrikeCalculator strikeCalculator;

    @BeforeEach
    public void beforeSet() {
        strikeCalculator = new StrikeCalculator(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isCounted3StrikeWhen123And123() {
        String test123 = "123";
        Assertions.assertEquals(strikeCalculator.getStrikesCnt(test123,test123),3);
    }

    @Test
    public void isCounted1Strike() {
        String test123 = "123";
        Assertions.assertEquals(strikeCalculator.getStrikesCnt(test123,"174"),1);
        Assertions.assertEquals(strikeCalculator.getStrikesCnt(test123,"825"),1);
        Assertions.assertEquals(strikeCalculator.getStrikesCnt(test123,"573"),1);
    }
}
