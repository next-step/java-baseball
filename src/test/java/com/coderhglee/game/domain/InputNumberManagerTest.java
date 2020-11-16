package com.coderhglee.game.domain;

import com.coderhglee.game.exception.ContainSameNumberException;
import com.coderhglee.game.exception.ExceedAllowLengthException;
import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.exception.NotAllowValueException;
import com.coderhglee.game.number.RandomInputNumber;
import com.coderhglee.game.number.UserInputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class InputNumberManagerTest {

    @DisplayName("랜덤 생성 함수가 허용 길이 만큼 제대로 생성되는지 확인")
    @Test
    public void checkRandomInputNumberSize() throws GameException {
        RandomInputNumber randomInputNumber = new RandomInputNumber();
        assertThat(randomInputNumber.getInputNumber().getGameNumbers().size()).isEqualTo(GameSettingNumbers.INPUT_MESSAGE_MAX_LENGTH.value);
    }

    @DisplayName("사용자 입력 숫자가 게임 숫자 그룹 함수로 만들어지는지 확인 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "345", "456"})
    public void userInputNumberMakeGameGroupsNumbers(String inputValue) throws GameException {
        UserInputNumber userInputNumber = new UserInputNumber(inputValue);
        assertThat(userInputNumber.getInputNumber().getGameNumbers().size()).isEqualTo(inputValue.length());
    }

    @DisplayName("허용 되지 않은 숫자에 대해서 예외 처리가 작동하고 예상하는 예외 클래스와 일치하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("ExactedException")
    public void shouldExpectedExceptionWhenIncludeNotAllowValues(String inputValue, Class exception) {
        assertThatThrownBy(() -> {
            UserInputNumber userInputNumber = new UserInputNumber(inputValue);
        }).isInstanceOf(exception);
    }

    public static Stream<Arguments> ExactedException() {
        return Stream.of(
                Arguments.of("null", NotAllowValueException.class),
                Arguments.of("333", ContainSameNumberException.class),
                Arguments.of("4a6", NotAllowValueException.class),
                Arguments.of(" ", NotAllowValueException.class),
                Arguments.of("1121", ExceedAllowLengthException.class)
        );
    }
}
