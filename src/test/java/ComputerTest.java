import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerTest {

    private final Computer computer = new Computer();

    @BeforeEach
    void setUp() {
        computer.initializeNewNumbers();
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 3자리 수 이어야 한다.")
    void isThreeDigitNumberTest() {
        // then
        assertThat(computer.getNumbers().size()).isEqualTo(Computer.NUMBERS_LENGTH);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 자연수로 이루어져야 한다.")
    void isConsistOfNaturalNumberTest() {
        // then
        for (Integer number : computer.getNumbers()) {
            assertThat(number).isBetween(Computer.MIN_NUMBER, Computer.MAX_NUMBER);
        }
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 서로 다른 숫자로 이루어져야 한다.")
    void isConsistOfUniqueNumberTest() {
        // when (computer가 생성한 숫자는 현재 HashSet 이지만, 나중에 바뀔 것을 대비하여 ArrayList로 변환 후 HashSet과 중복 검사 수행)
        ArrayList<Integer> numberList = Lists.newArrayList(computer.getNumbers());
        HashSet<Integer> numberSet = new HashSet<>();

        for (Integer number : numberList) {
            numberSet.add(number);
        }

        // then
        assertThat(numberList.size()).isEqualTo(numberSet.size());
    }

//    @ParameterizedTest
//    @ValueSource(strings = { "123", "724", "826" })
//    @DisplayName("스트라이크, 볼, 낫싱 판별이 정상적으로 이루어져야 한다.")
//    void isHintResultCorrectTest(String answer1, String answer2, String answer3) { }

    @ParameterizedTest
    @ValueSource(strings = { "12", "7243", "15326" })
    @DisplayName("제시된 숫자의 길이가 3자리가 아니면 예외가 발생한다.")
    void answerLengthExceptionTest(String answer) {
        // when, then
        assertThatThrownBy(() -> computer.generateResult(answer)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "103", "049", "000" })
    @DisplayName("제시된 숫자가 자연수로 이루어지지 않으면 예외가 발생한다.")
    void answerNaturalNumberExceptionTest(String answer) {
        // when, then
        assertThatThrownBy(() -> computer.generateResult(answer)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "133", "494", "777" })
    @DisplayName("제시된 숫자가 서로 다른 숫자로 이루어지지 않으면 예외가 발생한다.")
    void answerUniqueNumberExceptionTest(String answer) {
        // when, then
        assertThatThrownBy(() -> computer.generateResult(answer)).isInstanceOf(IllegalArgumentException.class);
    }
}