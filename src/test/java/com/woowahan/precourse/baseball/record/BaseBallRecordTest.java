package com.woowahan.precourse.baseball.record;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallRecordTest {

    private static BaseBallRecord baseBallRecord;

    @BeforeEach
    public void init() {
        baseBallRecord = new BaseBallRecord();
    }

    @Test
    @DisplayName("같은 자리의 수가 동일하면 strike count가 증가하고 같은 자리는 아니지만 숫자를 포함하고 있으면 ball count 증가")
    void doRecordTest() {

        String[] gameNumber = new String[]{"3", "5", "4"};
        String[] inputNumber = new String[]{"2", "3", "4"};

        baseBallRecord.doRecord(gameNumber, inputNumber);

        assertThat(baseBallRecord.getStrikeCount()).isEqualTo(1);
        assertThat(baseBallRecord.getBallCount()).isEqualTo(1);
    }
}
