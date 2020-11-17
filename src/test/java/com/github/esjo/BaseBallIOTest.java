package com.github.esjo;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BaseBallIOTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",// 정수형 아님
            "1234", // 3자리이상
            "111" // 중복포함
    })
    @DisplayName("사용자정의 예외 발생 테스트 - 3자리 중복없는 정수만 입력가능")
    void tsetReadThreeDigits(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BaseBallIO baseBallIO = BaseBallIO.createBaseBallIO(inputStream);
        assertThat(baseBallIO).as("객체 null여부 확인").isNotNull();

        assertThatThrownBy(() -> {
            baseBallIO.readThreeDigits();
        }).as("사용자 정의 에러발생").hasMessageContaining("[Tip]");
    }

}
