package com.baseball.game.domain;

import com.baseball.game.exception.BaseBallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("타자 생성 테스트")
class BatterTest {
    @ParameterizedTest
    @CsvSource(value = {"123:123", "462:462", "578:578"}, delimiter = ':')
    @DisplayName("입력한 값 및 위치(index)대로 numberBox가 생성된다. ")
    void isEqualsValueAndIndexWhenGenerated(String input, String expected) {
        Batter batter = Batter.create(Integer.parseInt(input));
        assertEquals(expected, batter.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1234})
    @DisplayName("0~1000 범위를 벗어난 숫자는 생성이 실패한다.")
    public void throwOutOfRange(int numbers){
        assertThatThrownBy(() -> {
            Batter.create(numbers);
        }).isInstanceOf(BaseBallException.class).hasMessageContaining("0 ~ 1,000 사이의 숫자만 입력해 주세요");
    }

    @ParameterizedTest
    @ValueSource(ints = {122, 334, 555, 991})
    @DisplayName("중복된 숫자가 입력되는 경우 생성이 실패한다.")
    public void throwParseInteger(int numbers){
        assertThatThrownBy(() -> {
            Batter.create(numbers);
        }).isInstanceOf(BaseBallException.class).hasMessageContaining("1~9까지 서로 다른 3자리 숫자로 입력해 주세요");
    }
}