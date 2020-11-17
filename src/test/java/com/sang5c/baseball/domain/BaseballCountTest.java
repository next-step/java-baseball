package com.sang5c.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class BaseballCountTest {

    @DisplayName("카운트의 합은 0이상 3이하이다")
    @Test
    public void countSum() {
        assertThatCode(() -> new BaseballCount(0, 3)).doesNotThrowAnyException();
    }

}
