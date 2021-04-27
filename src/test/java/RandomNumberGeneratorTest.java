import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    @DisplayName("1 ~ 9 사이의 사이즈를 입력하면 해당 길이의 랜덤값을 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void generateTest(int size) {
        String number = RandomNumberGenerator.generate(size);
        assertThat(number.length()).isEqualTo(size);
    }

    @DisplayName("0 이하의 수를 입력하면 최솟값인 1 길이의 숫자 생성")
    @ParameterizedTest
    @CsvSource(value = {
            "0, 1",
            "-1, 1",
            "-100, 1"
    })
    void generateMinTest(int size, int expected) {
        String number = RandomNumberGenerator.generate(size);
        assertThat(number.length()).isEqualTo(expected);
    }

    @DisplayName("10 이상의 수를 입력하면 최댓값인 9 길이의 숫자 생성")
    @ParameterizedTest
    @CsvSource(value = {
            "10, 9",
            "100, 9"
    })
    void generateMaxTest(int size, int expected) {
        String number = RandomNumberGenerator.generate(size);
        assertThat(number.length()).isEqualTo(expected);
    }
}