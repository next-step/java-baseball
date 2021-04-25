package techcamp.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @DisplayName("입력값 검증")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"123", "356", "962"})
    public void validate_input_size(String input) {
        //Given
        Validation validation = new Validation();
        List<Integer> numbers = new ArrayList<>();

        //When
        List<String> strInputs = new ArrayList<>(Arrays.asList(input.split("")));
        for (String strInput : strInputs) {
            numbers.add(Integer.valueOf(strInput));
        }

        //Then
        assertTrue(validation.isAllowableSize(input), "입력된 값의 길이는 설정된 값과 같아야 한다.");
        assertTrue(validation.isDigit(input), "입력된 값은 전부 숫자여야 한다.");
        for (int number : numbers) {
            assertTrue(validation.isAllowableDigit(number), "입력된 값은 설정된 범위내의 숫자여야 한다.");
        }
    }
}