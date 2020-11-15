import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballHintMakerTest {

    @Test
    public void getStrikeHint() {
        ArrayList<Integer> correctNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(4, 2, 3));
        BaseballHintMaker hintMaker = new BaseballHintMaker(correctNumbers, inputNumbers);
        Strike strike = hintMaker.getStrikeHint();
        assertThat(strike.getCount()).isEqualTo(2);
    }

}
