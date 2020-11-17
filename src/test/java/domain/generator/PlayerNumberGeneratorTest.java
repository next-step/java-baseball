package domain.generator;

import domain.generator.PlayerNumberGenerator;
import domain.number.BaseBallNumber;
import exception.BaseBallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNumberGeneratorTest {

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자 BaseBallNumber 생성 테스트")
    @CsvSource(value = {"123:1", "456:5", "789:9"}, delimiter = ':')
    void generate_basic_ball_number_test (int input, int expected) {

        // given
        PlayerNumberGenerator playerNumberGenerator = new PlayerNumberGenerator(input);

        // when
        List<BaseBallNumber> baseBallNumbers = playerNumberGenerator.getNumbers();

        // then
        assertThat(baseBallNumbers).contains(new BaseBallNumber(expected));
    }

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자가 세자리 정수인 테스트")
    @ValueSource(ints = {1234, 4567, 8910})
    void check_number_length (int input) {
        assertThatThrownBy(() -> {
            PlayerNumberGenerator playerNumberGenerator = new PlayerNumberGenerator(input);
        }).isInstanceOf(BaseBallException.class)
                .hasMessage("세자리 정수를 입력해 주세요");
    }

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자에 중복이 있는지 테스트")
    @ValueSource(ints = {122, 334, 777})
    void check_duplicate_number (int input) {
        assertThatThrownBy(() -> {
            PlayerNumberGenerator playerNumberGenerator = new PlayerNumberGenerator(input);
        }).isInstanceOf(BaseBallException.class)
                .hasMessage("입력한 각 자리 숫자는 중복 될 수 없습니다.");
    }

}
