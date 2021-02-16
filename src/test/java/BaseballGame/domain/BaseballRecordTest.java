package BaseballGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballRecordTest {

    @DisplayName("이닝 기록 테스트")
    @Test
    void recordInningResult() {
        // given
        BaseballRecord baseballRecord = new BaseballRecord();
        Inning inning1 = new Inning(123, 0, 1);
        Inning inning2 = new Inning(456, 0, 1);

        // when
        baseballRecord.recordInningResult(inning1);
        baseballRecord.recordInningResult(inning2);

        // then
        assertThat(baseballRecord.getChart()).hasSize(2);
    }
}
