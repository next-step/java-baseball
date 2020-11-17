package com.sang5c.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    @DisplayName("3개의 숫자 문자열로 야구 객체를 생성한다")
    @Test
    public void create() {
        assertThat(new Baseball("123")).isNotNull();
    }

}
