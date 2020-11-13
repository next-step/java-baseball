package me.totoku103.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    @Test
    @DisplayName("최초 앱 개발 테스트")
    public void startApplication() {
        final String[] args = {};
        me.totoku103.baseball.Application.main(args);
    }
}