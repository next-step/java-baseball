package convert;

import baseball.convert.BaseBallConvert;
import baseball.convert.BaseBallNumberConvert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @DisplayName("3자리수의 숫자를 받으면 3자리의 배열을 반환하는지 확인한다.")
    @CsvSource(value = {"123:3", "320:3"}, delimiter = ':')
    public void test_convert_three_values_length(int source, int expected) {
        BaseBallConvert convert = new BaseBallNumberConvert();
        int[] actual = convert.convert(source);
        assertThat(actual.length).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @DisplayName("특정자리수의 숫자를 받으면 특정자리수의 배열을 반환하는지 확인한다.")
    @CsvSource(value = {"1:1", "12:2", "123:3", "4567:4"}, delimiter = ':')
    public void test_convert_values_length(int source, int expected) {
        BaseBallConvert convert = new BaseBallNumberConvert();
        int[] actual = convert.convert(source);
        assertThat(actual.length).isEqualTo(expected);
    }

    @Test
    @DisplayName("int배열로 변환된 값에 해당 값이 존재 하는지 확인.")
    public void test_has_values_convert_value() {
        BaseBallConvert convert = new BaseBallNumberConvert();
        int[] actual = convert.convert(123);

        assertThat(actual).contains(3);
        assertThat(actual).contains(2);
        assertThat(actual).contains(1);
    }

    @Test
    @DisplayName("int배열로 변환된 값에 해당 값이 순서대로 존재 하는지 확인.")
    public void test_has_values_convert_sequence_value() {
        BaseBallConvert convert = new BaseBallNumberConvert();
        int[] actual = convert.convert(157);

        assertThat(actual).containsSequence(1, 5, 7);
    }

}
