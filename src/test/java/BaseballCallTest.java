import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import referee.BaseballCall;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballCallTest {
    @ParameterizedTest
    @CsvSource({"123,123,true","123,124,false","123,178,false","123,985,false"})
    public void callTest(String player, String counter, boolean expected){
        assertThat(BaseballCall.callMethod(player, counter)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"123,456,0","123,231,0","546,578,1","378,176,1","839,219,1","546,246,2","378,328,2","839,837,2","754,754,3"})
    public void strikeCountTest(String player, String counter, int expected){
        assertThat(BaseballCall.cntStrike(player, counter)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"123,456,0","546,578,0","546,548,0","126,283,1","546,234,1","546,451,2","546,164,2","123,231,3","932,293,3"})
    public void ballCountTest(String player, String counter, int expected){
        assertThat(BaseballCall.cntBall(player, counter, BaseballCall.cntStrike(player, counter))).isEqualTo(expected);
    }

}
