import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class JudgeTest {
    @Test
    public void testJudgeWithSampleData() {
        assertThat(Judge.judge(new int[]{1, 2, 3}, new int[]{1, 2, 3})).isEqualTo(new int[]{3, 0});
        assertThat(Judge.judge(new int[]{1, 2, 3}, new int[]{3, 2, 1})).isEqualTo(new int[]{1, 2});
        assertThat(Judge.judge(new int[]{3, 6, 9}, new int[]{6, 9, 3})).isEqualTo(new int[]{0, 3});
        assertThat(Judge.judge(new int[]{1, 2, 3}, new int[]{2, 3, 4})).isEqualTo(new int[]{0, 2});
        assertThat(Judge.judge(new int[]{1, 2, 3}, new int[]{7, 8, 9})).isEqualTo(new int[]{0, 0});
        assertThat(Judge.judge(new int[]{9, 5, 1}, new int[]{9, 4, 1})).isEqualTo(new int[]{2, 0});
    }

    @Test
    public void testJudgeSpeak() {
        assertThat(Judge.speak(new int[]{3, 0})).isEqualTo(Judge.STRIKE_OUT);
        assertThat(Judge.speak(new int[]{0, 0})).isEqualTo(Judge.NOTHING);
        assertThat(Judge.speak(new int[]{1, 0})).isEqualTo(1 + Judge.STRIKE);
        assertThat(Judge.speak(new int[]{2, 0})).isEqualTo(2 + Judge.STRIKE);
        assertThat(Judge.speak(new int[]{0, 1})).isEqualTo(1 + Judge.BALL);
        assertThat(Judge.speak(new int[]{0, 2})).isEqualTo(2 + Judge.BALL);
        assertThat(Judge.speak(new int[]{0, 3})).isEqualTo(3 + Judge.BALL);
        assertThat(Judge.speak(new int[]{1, 1})).isEqualTo(1 + Judge.STRIKE + 1 + Judge.BALL);
        assertThat(Judge.speak(new int[]{1, 2})).isEqualTo(1 + Judge.STRIKE + 2 + Judge.BALL);
    }
}
