import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseballServiceTest {

    private Baseball baseball;

    @BeforeEach
    public void setup() {
        baseball = new Baseball();
    }

    @Test
    public void 랜덤_숫자_생성() {
        baseball.setOpponentNumber(BaseUtil.getRandomNumber());

        assertThat(baseball.getOpponentNumber().size() == 3).isTrue();
    }

    @Test
    public void 랜덤_숫자_중복_확인() {
        baseball.setOpponentNumber(BaseUtil.getRandomNumber());
        Set<Integer> set = new HashSet<>(baseball.getOpponentNumber());

        assertThat(set.size() == 3).isTrue();
    }

    @Test
    public void 게임_완료_조건_확인() {
        baseball.setOpponentNumber(BaseUtil.getRandomNumber());
        List<Integer> userNumber = new ArrayList<>();
        for (Integer number : baseball.getOpponentNumber()) {
            userNumber.add(number);
        }
        baseball.setUserNumber(userNumber);
        baseball.compare();

        assertThat(baseball.isStrike()).isTrue();
    }

    @Test
    public void 볼_스트라이크_확인() {
        baseball.setOpponentNumber(BaseUtil.getRandomNumber());
        List<Integer> userNumber = new ArrayList<>();
        for (Integer number : baseball.getOpponentNumber()) {
            userNumber.add(number);
        }
        Collections.reverse(userNumber);
        baseball.setUserNumber(userNumber);
        baseball.compare();

        assertThat(baseball.getBall() == 2).isTrue();
        assertThat(baseball.getStrike() == 1).isTrue();
    }

}