import domain.BaseballGameInfo;
import domain.BaseballNumberGenerator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BaseballGameInfoTest {

    @Test
    public void BaseballGameInfo() throws Exception {

        List userBaseballNumbersCase1 = Arrays.asList(1, 3, 5);
        List targetBaseballNumbersCase1 = Arrays.asList(1, 3, 5);

        BaseballGameInfo baseballGameInfoCase1 = new BaseballGameInfo(userBaseballNumbersCase1, targetBaseballNumbersCase1);

        assertThat(baseballGameInfoCase1.getStrikeCount()).isEqualTo(3);
        assertThat(baseballGameInfoCase1.getBallCount()).isEqualTo(0);
        assertThat(baseballGameInfoCase1.getIsWinning()).isTrue();

        List userBaseballNumbersCase2 = Arrays.asList(1, 5, 3);
        List targetBaseballNumbersCase2 = Arrays.asList(1, 3, 5);
        BaseballGameInfo baseballGameInfoCase2 = new BaseballGameInfo(userBaseballNumbersCase2, targetBaseballNumbersCase2);

        assertThat(baseballGameInfoCase2.getStrikeCount()).isEqualTo(1);
        assertThat(baseballGameInfoCase2.getBallCount()).isEqualTo(2);
        assertThat(baseballGameInfoCase2.getIsWinning()).isFalse();
    }
}
