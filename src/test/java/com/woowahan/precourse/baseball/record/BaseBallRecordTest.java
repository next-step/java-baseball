package com.woowahan.precourse.baseball.record;

import static org.assertj.core.api.Assertions.assertThat;

import com.woowahan.precourse.baseball.domain.BaseBallRecord;
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
    @DisplayName("doStrike() 실행 시 strikeCount가 1씩 증가 한다.")
    void doStrikeTest() {

        // given
        baseBallRecord.doStrike();
        baseBallRecord.doStrike();
        baseBallRecord.doStrike();

        // when
        int strikeCount = baseBallRecord.getStrikeCount();

        //then
        assertThat(strikeCount).isEqualTo(3);
    }


    @Test
    @DisplayName("doBall() 실행 시 ballCount가 1씩 증가 한다.")
    void doBallTest() {

        // given
        baseBallRecord.doBall();
        baseBallRecord.doBall();

        // when
        int ballCount = baseBallRecord.getBallCount();

        //then
        assertThat(ballCount).isEqualTo(2);
    }
}
