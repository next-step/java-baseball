package baseball;

import baseball.judgment.Ball;
import baseball.judgment.JudgmentService;
import baseball.judgment.Strike;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgmentTest {
    @Test
    public void judgeTest() {
        assertThat(JudgmentService.judge(new Strike(),-1,1)).isEqualTo(0) ;
        assertThat(JudgmentService.judge(new Strike(),1,1)).isEqualTo(1) ;
        assertThat(JudgmentService.judge(new Ball(),1,2)).isEqualTo(1) ;
        assertThat(JudgmentService.judge(new Ball(),-1,2)).isEqualTo(0) ;
    }
}
