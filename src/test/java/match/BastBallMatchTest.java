package match;

import baseball.Inning;
import baseball.match.BaseBallInningPlay;
import baseball.match.BaseBallPlay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BastBallMatchTest {

    @Test
    @DisplayName("동일한 위치에 값이 존재시 스트라이크 값 잘 반환되는지 확인 한다.")
    public void checkStrikeTest() {
        int[] source = {1, 2, 3};
        int[] target = {1, 2, 3};

        BaseBallPlay baseBallMatch = new BaseBallInningPlay();
        Inning inning = baseBallMatch.play(source, target);
        int actual = inning.getStrike();
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("동일한 숫자가 다른 위치에 존재시 볼 값이 반환 되는지 확인한다.")
    public void checkBallTest() {
        int[] source = {1, 2, 3};
        int[] target = {3, 1, 2};

        BaseBallPlay baseBallMatch = new BaseBallInningPlay();
        Inning inning = baseBallMatch.play(source, target);
        int actual = inning.getBall();
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크와 볼이 이상없이 잘 반환 되는지 확인한다.")
    public void checkStrikeAndBallTest() {
        int[] source = {1, 2, 3};
        int[] target = {1, 5, 2};

        BaseBallPlay baseBallMatch = new BaseBallInningPlay();
        Inning inning = baseBallMatch.play(source, target);
        assertThat(inning.getStrike()).isEqualTo(1);
        assertThat(inning.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("모든값이 틀릴 경우 스트라이크와 볼은 0을 반환한다.")
    public void checkNotMatchStrikeAndBallTest() {
        int[] source = {1, 2, 3};
        int[] target = {4, 5, 6};

        BaseBallPlay baseBallMatch = new BaseBallInningPlay();
        Inning inning = baseBallMatch.play(source, target);
        assertThat(inning.getStrike()).isEqualTo(0);
        assertThat(inning.getBall()).isEqualTo(0);
    }

}
