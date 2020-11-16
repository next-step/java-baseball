package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameNumberTest {

    @Test
    @DisplayName("생성 시 3개의 한 자리 게임 숫자(GameDigit) 를 가지지 않으면 예외를 발생시킨다.")
    void createValidationLengthTest() {
        List<GameDigit> gameDigits = new ArrayList<>();
        gameDigits.add(new GameDigit(0));
        gameDigits.add(new GameDigit(1));
        gameDigits.add(new GameDigit(2));
        gameDigits.add(new GameDigit(3));
        assertThatThrownBy(() -> new GameNumber(gameDigits))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성 시 중복된 한 자리 게임 숫자(GameDigit) 가 있으면 예외를 발생시킨다.")
    void createValidationDuplicationTest() {
        List<GameDigit> gameDigits = new ArrayList<>();
        gameDigits.add(new GameDigit(0));
        gameDigits.add(new GameDigit(1));
        gameDigits.add(new GameDigit(0));
        assertThatThrownBy(() -> new GameNumber(gameDigits))
                .isInstanceOf(IllegalArgumentException.class);
    }
}