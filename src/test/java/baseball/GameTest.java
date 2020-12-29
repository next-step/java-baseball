package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    @Test
    public void testMakeNumbers(){
        int[] numbers = Game.makeNumbers();
        int[] base = {1,2,3,4,5,6,7,8,9};

        assertThat(numbers[0] != numbers[1]
                && numbers[1] != numbers[2]
                && numbers[0] != numbers[2]).isTrue();
        assertThat(base).contains(numbers);
    }
}
