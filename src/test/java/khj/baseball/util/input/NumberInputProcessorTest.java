package khj.baseball.util.input;

import khj.baseball.exception.DuplicateInputException;
import khj.baseball.exception.LengthWrongInputException;
import khj.baseball.exception.TypeWrongInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberInputProcessorTest {
    InputProcessor inputProcessor = new DefaultInputProcessor();

    @ParameterizedTest(name = "파라미터로 넘긴 값 {arguments}이 넘어오는 지 확인")
    @ValueSource(strings = {"123", "456", "789"})
    void inputNumberString(String arg) {
        ByteArrayInputStream stream = new ByteArrayInputStream(arg.getBytes());
        System.setIn(stream);

        String inputString = inputProcessor.inputNumberString(3);

        assertEquals(arg, inputString);
    }

    @DisplayName("파라미터로 보낸 길이와 다른 길이의 문자열을 입력했을 경우 예외가 발생한다.")
    @Test
    void inputNumberStringLength() {
        ByteArrayInputStream stream = new ByteArrayInputStream("1234".getBytes());
        System.setIn(stream);

        assertThrows(LengthWrongInputException.class, () -> {
            inputProcessor.inputNumberString(3);
        });
    }

    @DisplayName("같은 문자가 중복되어 입력이 되면 예외가 발생한다..")
    @Test
    void inputNumberStringDuplicate() {
        ByteArrayInputStream stream = new ByteArrayInputStream("113".getBytes());
        System.setIn(stream);

        assertThrows(DuplicateInputException.class, () -> {
            inputProcessor.inputNumberString(3);
        });
    }

    @DisplayName("숫자가 아닌 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputNumberStringTypeWrong() {
        ByteArrayInputStream stream = new ByteArrayInputStream("1a2".getBytes());
        System.setIn(stream);

        assertThrows(TypeWrongInputException.class, () -> {
            inputProcessor.inputNumberString(3);
        });
    }
}
