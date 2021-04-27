package com.bistros.game.domain;

import com.bistros.game.domain.exception.BallNumberRuleAgainstException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallNumbersTest {

    @Test
    @DisplayName("중복이 포함된 숫자를 가지고 BallNumbers 를 생성하려고 하면 예외가 발생한다")
    void whenUsedDuplicateUsingNumber_throwException() {
        List<Integer> chars = Arrays.asList(2, 7, 2);
        assertThrows(BallNumberRuleAgainstException.class,
            () -> new BallNumbers(chars));
    }

    @Test
    @DisplayName("BallNumbers를 만들때 null 이 들어오거나, length 가 작을 경우 예외가 발생한다")
    void whenExistNullValue_throwException() {
        assertAll(
            () -> assertThrows(BallNumberRuleAgainstException.class, () -> new BallNumbers(null)),
            () -> assertThrows(BallNumberRuleAgainstException.class, () -> new BallNumbers(Arrays.asList(2, 7)))
        );
    }

    @Test
    @DisplayName("BallNumbers 의 toString 을 호출했을때 " + BallNumbers.LENGTH + "자리의 문자열이 출력된다")
    void whenBallNumber_call_toString_then_return_string() {
        BallNumbers actualNumbers = new BallNumbers(Arrays.asList(7, 5, 1));

        String expectedString = "751";

        assertThat(actualNumbers.toString()).isEqualTo(expectedString);
    }

}