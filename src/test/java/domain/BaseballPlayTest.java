package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballPlayTest {

    @DisplayName("랜덤 세자리 숫자에 대한 사용자 입력 값 Strike, Ball Count")
    @Test
    void strikeAndBallCount() {
        List<Integer> randomNumbers = Arrays.asList(3, 4, 5);
        List<Integer> inputNumbers = Arrays.asList(3, 2, 5);
        BaseballPlay baseballPlay = new BaseballPlay(randomNumbers);

        baseballPlay.play(inputNumbers);

        assertThat(baseballPlay.getBallCount()).isEqualTo(1);
        assertThat(baseballPlay.getStrikeCount()).isEqualTo(2);
    }
}