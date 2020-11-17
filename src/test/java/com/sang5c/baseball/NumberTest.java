package com.sang5c.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자는 1부터 9까지 생성 가능하다")
    @Test
    public void validRange() {
        assertThatCode(() -> new Number(1)).doesNotThrowAnyException();
        assertThatCode(() -> new Number(9)).doesNotThrowAnyException();
    }

}
