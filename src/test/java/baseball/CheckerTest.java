package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckerTest {

    private final Checker checker = new Checker();

    @Test
    @DisplayName("같은 수일 경우 1을 반환한다")
    public void compareEqualTest() {
        int actual = checker.compare(1, 1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("다른 수일 경우 0을 반환한다")
    public void compareNotEqualTest() {
        int actual = checker.compare(1, 2);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 수를 반환한다")
    public void checkStrikeTest() {
        List<Integer> computer = List.of(3, 8, 6);
        List<Integer> user1 = List.of(3, 8, 6);
        List<Integer> user2 = List.of(8, 3, 5);
        List<Integer> user3 = List.of(3, 4, 5);
        assertThat(checker.checkStrike(computer, user1)).isEqualTo(3);
        assertThat(checker.checkStrike(computer, user2)).isEqualTo(0);
        assertThat(checker.checkStrike(computer, user3)).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 수를 반환한다")
    public void checkBallTest() {
        List<Integer> computer = List.of(3, 8, 6);
        List<Integer> user1 = List.of(3, 8, 6);
        List<Integer> user2 = List.of(8, 3, 5);
        List<Integer> user3 = List.of(3, 4, 5);
        assertThat(checker.checkBall(computer, user1)).isEqualTo(0);
        assertThat(checker.checkBall(computer, user2)).isEqualTo(2);
        assertThat(checker.checkBall(computer, user3)).isEqualTo(0);
    }
}
