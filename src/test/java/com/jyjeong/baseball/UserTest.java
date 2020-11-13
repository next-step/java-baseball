package com.jyjeong.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    private User user = new User();

    @ParameterizedTest
    @ValueSource(strings = "1234")
    @DisplayName("입력된 값의 범위가 초과되었을때 에러발생 테스트")
    void validLength(String userNumber){
        //then
        assertThatThrownBy(() ->{
            user.validate(userNumber);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("입력된 값의 범위가 초과 되었습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    @DisplayName("입력된 값이 숫자가 아닐때 에러발생 테스트")
    void validNumber(String userNumber){
        //then
        assertThatThrownBy(() ->{
            user.validate(userNumber);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("입력된 값이 숫자가 아닙니다");
    }
}