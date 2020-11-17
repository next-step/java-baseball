package com.sang5c.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseballCountTest {

    @DisplayName("카운트의 합은 0이상 3이하이다")
    @Test
    public void countSum() {
        assertThatCode(() -> BaseballCount.of(0, 3)).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(() -> BaseballCount.of(1, 3));
    }

}
