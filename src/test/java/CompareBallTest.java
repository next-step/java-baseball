import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareBallTest {

    CompareBall compareBall;

    @BeforeEach
    public void setUp() {
        compareBall = new CompareBall();
    }

    @Test
    @DisplayName("스트라이크 검증 테스트")
    public void checkStrike() {
        List<Integer> gameBall = new ArrayList<>();
        gameBall.add(3);
        gameBall.add(4);
        gameBall.add(5);
        List<Integer> userInput = new ArrayList<>();
        userInput.add(3);
        userInput.add(4);
        userInput.add(5);
        assertThat(compareBall.checkStrike(userInput, gameBall)).isEqualTo(3);
    }

    @Test
    @DisplayName("볼 검증 테스트")
    public void checkBall() {
        List<Integer> gameBall = new ArrayList<>();
        gameBall.add(3);
        gameBall.add(4);
        gameBall.add(5);
        List<Integer> userInput = new ArrayList<>();
        userInput.add(3);
        userInput.add(2);
        userInput.add(5);
        assertThat(compareBall.checkBall(userInput, gameBall)).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 동작 테스")
    public void checkStart() {
        List<Integer> gameBall = Arrays.asList(3, 4, 5);
        List<Integer> userInput = Arrays.asList(3, 4, 5);
        assertThat(compareBall.checkStart(userInput, gameBall)).isEqualTo("3 스트라이크 ");
        List<Integer> gameBall2 = Arrays.asList(1, 4, 5);
        List<Integer> userInput2 = Arrays.asList(3, 4, 5);
        assertThat(compareBall.checkStart(userInput2, gameBall2)).isEqualTo("2 스트라이크 ");
        List<Integer> gameBall3 = Arrays.asList(1, 4, 5);
        List<Integer> userInput3 = Arrays.asList(1, 5, 4);
        assertThat(compareBall.checkStart(userInput3, gameBall3)).isEqualTo("1 스트라이크 2 볼");
    }
}
