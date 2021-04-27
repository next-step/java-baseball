package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReceivingPlayAgainAnswerTest {
    private ReceivingPlayAgainAnswer receivingPlayAgainAnswer;

    @DisplayName("입력 값이 1(RESTART_CODE) 또는 2(EXIT_CODE)가 아닐 경우 재입력 요청하여 NoSuchElementException 발생")
    @ParameterizedTest(name = "{index} {displayName} answer={0}")
    @ValueSource(strings = {"1", "2"})
    public void when_receive_RESTART_CODE_or_EXIT_CODE(String inputValue){
        receivingPlayAgainAnswer = new ReceivingPlayAgainAnswer(new Scanner(inputValue));
        int answer = receivingPlayAgainAnswer.receivePlayAgainAnswer();
        assertThat(answer).isEqualTo(Integer.parseInt(inputValue));
    }

    @DisplayName("입력 값이 1(RESTART_CODE) 또는 2(EXIT_CODE)가 아닐 경우 재입력 요청하여 NoSuchElementException 발생")
    @ParameterizedTest(name = "{index} {displayName} answer={0}")
    @ValueSource(strings = {"3", "aaa", "12", "1a"})
    @EmptySource
    public void throw_NoSuchElementException_when_answer_not_include_RESTART_CODE_or_EXIT_CODE_or_empty_value(String inputValue){
        receivingPlayAgainAnswer = new ReceivingPlayAgainAnswer(new Scanner(inputValue));
        assertThrows(NoSuchElementException.class, ()-> receivingPlayAgainAnswer.receivePlayAgainAnswer());
    }
}