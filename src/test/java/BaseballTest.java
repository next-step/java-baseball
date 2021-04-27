import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class BaseballTest {
    @Test
    @DisplayName("스트라이크를 계산한다")
    void testStrike(){
        assertThat(Baseball.calculateStrike('1','1')).isEqualTo(1);
        assertThat(Baseball.calculateStrike('1','2')).isEqualTo(0);
    }

    @Test
    @DisplayName("볼을 계산한다")
    void testBall(){
        String source = "123";
        String target = "234";
        assertThat(Baseball.calculateBall(source,target,0)).isEqualTo(1);
        assertThat(Baseball.calculateBall(source,target,1)).isEqualTo(1);
        assertThat(Baseball.calculateBall(source,target,2)).isEqualTo(0);
    }

    @Test
    @DisplayName("3스트라이크면 게임을 종료한다")
    void testFinished(){
        assertThat(Baseball.finished(3, 0)).isTrue();
    }

    @Test
    @DisplayName("게임 종료여부를 테스트")
    void testGameFinished(){
        assertThat(Baseball.gameFinished("123","456")).isFalse();
        assertThat(Baseball.gameFinished("123","156")).isFalse();
        assertThat(Baseball.gameFinished("123","425")).isFalse();
        assertThat(Baseball.gameFinished("123","453")).isFalse();
        assertThat(Baseball.gameFinished("123","123")).isTrue();
    }
}
