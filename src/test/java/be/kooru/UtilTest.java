package be.kooru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

class UtilTest {

    @DisplayName("랜덤으로 생성한 숫자 개수가 입력된 숫자와 같은지 확인")
    @ParameterizedTest
    @CsvSource({"3,1,9", "4,1,9", "3,2,5"})
    void generateRandomNumberCount(String number, String start, String end) {

        int extract = Integer.parseInt(number);
        int startNumber = Integer.parseInt(start);
        int endNumber = Integer.parseInt(end);
        int[] result = Util.generateRandomNumber(extract, startNumber, endNumber);

        Assertions.assertThat(result)
                .isNotNull()
                .hasSize(extract);
    }

    @DisplayName("랜덤으로 생성한 숫자의 범위가 입력된 숫자의 범위 내인지 확인")
    @ParameterizedTest
    @CsvSource({"3,1,9", "4,1,9", "3,2,5"})
    void generateRandomNumberRangeCheck(String number, String start, String end) {

        int extract = Integer.parseInt(number);
        int startNumber = Integer.parseInt(start);
        int endNumber = Integer.parseInt(end);
        int[] result = Util.generateRandomNumber(extract, startNumber, endNumber);
        int[] range = IntStream.rangeClosed(startNumber, endNumber).toArray();

        Assertions.assertThat(range)
                .contains(result);
    }

    @DisplayName("입력한 숫자가 정확하게 Array로 변환되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void convertStringToIntArray(String s) {
        int[] result = Util.convertStringToIntArray(s);

        Assertions.assertThat(result)
                .isNotNull()
                .hasSize(s.length())
                .startsWith(Integer.parseInt(s.substring(0, 1)))
                .endsWith(Integer.parseInt(s.substring(s.length() - 1, s.length())));
    }
}