import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import player.BaseballReferee;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("심판 테스트")
public class RefereeTest {

    @Test
    @DisplayName("스트라이크 카운트 확인")
    void strikeCount() {
        List<Integer> hitterNumbers = Arrays.asList(1, 2, 3);
        List<Integer> pitcherNumbers = Arrays.asList(1, 4, 5);
        int strikeCount = 1;
        BaseballReferee referee = new BaseballReferee(hitterNumbers, pitcherNumbers);
        referee.checkBaseball();

        assertEquals(referee.getStrikeCount(), strikeCount);
    }

    @Test
    @DisplayName("볼 카운트 확인")
    void ballCount() {
        List<Integer> hitterNumbers = Arrays.asList(1, 2, 3);
        List<Integer> pitcherNumbers = Arrays.asList(3, 1, 5);
        int ballCount = 2;
        BaseballReferee referee = new BaseballReferee(hitterNumbers, pitcherNumbers);
        referee.checkBaseball();

        assertEquals(referee.getBallCount(), ballCount);
    }
}
