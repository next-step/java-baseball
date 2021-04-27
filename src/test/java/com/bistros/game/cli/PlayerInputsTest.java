package com.bistros.game.cli;

import com.bistros.game.domain.BallNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerInputsTest {
    PlayerInputs inputs = new PlayerInputs();


    @Test
    @DisplayName("사용자 입력이 " + BallNumbers.LENGTH + "자리수가 안될 때 예외 발생")
    void when_user_input_not_enough_lengththen_throw_exception() {
        assertAll(
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert(null)),
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("12")),
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("1234"))
        );
    }


    @Test
    @DisplayName("사용자 입력에 1-9가 아닌 다른 문자열이 있을 경우 예외 발생")
    void when_user_input_not_allow_char_then_throw_exception() {
        assertAll(
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("012")),
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("A12")),
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("가12"))
        );
    }


    @Test
    @DisplayName("사용자 입력에 중복 숫자가 존재할 경우 예외 발생")
    void when_user_input_duplicate_char_then_throw_exception() {
        assertAll(
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("112")),
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("333")),
            () -> assertThrows(InvalidInputException.class, () -> inputs.convert("797"))
        );
    }

    @Test
    @DisplayName("게임 재시작을 위한 사용자 입력 확인")
    void check_user_input_for_restart_game() {
        assertAll(
            () -> assertThrows(InvalidInputException.class, () -> inputs.getRestartOpinion("")),
            () -> assertThat(inputs.getRestartOpinion("1")).isTrue(),
            () -> assertThat(inputs.getRestartOpinion("2")).isFalse()
        );
    }
}