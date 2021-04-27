package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListConverterTest {

    @DisplayName("입력 값이 숫자인 문자열이 변환된 List 길이와 값이 일치하는지 테스트")
    @ParameterizedTest(name = "{index} {displayName} receivedNumbers={0}")
    @ValueSource(strings = {"815", "2476", "15823", "1"})
    public void when_string_and_converted_list_have_same_length_and_value(String receivedNumbers) {

        //when
        List<Integer> baseballNumbers = ListConverter.convert(receivedNumbers);

        //then
        assertThat(baseballNumbers).hasSize(receivedNumbers.length());
        for (int i = 0; i < baseballNumbers.size(); i++) {
            int number = Character.getNumericValue(receivedNumbers.charAt(i));
            assertThat(baseballNumbers.get(i)).isEqualTo(number);
        }
    }

    @DisplayName("입력 값이 숫자가 아닌 문자열이 변환 시도하는 경우 IllegalArgumentException 던지기")
    @ParameterizedTest(name = "{index} {displayName} receivedNumbers={0}")
    @ValueSource(strings = {"abcde", "8a3", "815a", "a123"})
    public void throw_IllegalArgumentException_when_string_include_character(String receivedNumbers) {
        assertThrows(IllegalArgumentException.class, () -> ListConverter.convert(receivedNumbers));
    }
}