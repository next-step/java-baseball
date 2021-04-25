package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecordTest {

    @DisplayName("매치 포인트 값에 따라서 record 값 가져오는지 테스트")
    @Test
    void findRecord() {
        assertThat(Record.findRecord(2)).isEqualTo(Record.STRIKE);
        assertThat(Record.findRecord(1)).isEqualTo(Record.BALL);
        assertThat(Record.findRecord(0)).isEqualTo(Record.NOTHING);
    }
}
