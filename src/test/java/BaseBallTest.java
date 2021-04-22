import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {
    @DisplayName("야구게임 정답 난수 생성")
    @Test
    public void testMakeRandomAnswer() {
        List<Integer> answer = BaseBall.makeAnswer();
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.size()).isEqualTo(new HashSet<>(answer).size());
    }
}
