package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * InputViewTest
 * 사용자의 입력내용에 적절한 대응을 하는지 체크한다.
 * 2020.11.16.
 * parksangdonews
 */
class InputViewTest {

    @DisplayName(value = "1,2,3 처럼 , 로 split  하는 경우 (최초기대입력값) 제대로 분기되어 List 생성 되는가.")
    @ParameterizedTest
    @ValueSource(strings = {"3,5,7"})
    void splitByComma(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        List<Integer> splitedList;
        splitedList = InputView.setBallNumber(input);
        for (int i = 0; i < splitedList.size(); i++) {
            assertThat(Integer.valueOf(stringTokenizer.nextToken())).isEqualTo(splitedList.get(i));
        }
    }

    @DisplayName(value = "1,a,3 처럼 , 로 split 하는 경우 문자 오기 입력시 제대로 예외 처리 되는가.")
    @ParameterizedTest
    @ValueSource(strings = {"3,5,a", "56e", "!32", "4#8"})
    void splitByCommaWithCharater(String input) {
        assertThatThrownBy(() -> {
            InputView.setBallNumber(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력 가능");
    }

    /*

    @DisplayName(value = "1, 또는 2,3,4,5 처럼 과부족 입력상태에서 제대로 예외 처리 되는가.")
    @ParameterizedTest
    @ValueSource(strings = {"3,", "53", "!32345", "456788"})
    void splitError(String input) {
        assertThatThrownBy(() -> {
            InputView.setBallNumber(input);
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class).hasMessageContaining("숫자만 입력 가능");
    }

    */

    @DisplayName(value = "123 처럼 문자(숫자)단위로 split  하는 경우 제대로 분기되어 List 생성 되는가.")
    @ParameterizedTest
    @ValueSource(strings = {"357"})
    void splitWtithoutDelimiter(String input) {
        char[] chars = input.toCharArray();
        List<Integer> splitedList = InputView.setBallNumber(input);
        for (int i = 0; i < splitedList.size(); i++) {
            assertThat(String.valueOf(chars[i])).isEqualTo(String.valueOf(splitedList.get(i)));
        }
    }

}
