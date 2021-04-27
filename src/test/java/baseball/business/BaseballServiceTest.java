package baseball.business;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.etc.Constants;
import baseball.etc.Message;
import baseball.model.BaseNumbers;

class BaseballServiceTest {

    private BaseballService service;

    @BeforeEach
    void setUp() {
        service = new BaseballService();
    }

    @Test
    @DisplayName("숫자 게임 길이가 0 이라면 디폴트 값이 입력 되는지 확인.")
    void start_argsIsZero() {
        service.startGame(0);
        BaseNumbers baseNumbers = service.getBaseNumbers();

        assertThat(baseNumbers.getNumbers())
            .hasSize(Constants.BASEBALL_DEFAULT_NUMBER_SIZE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5000})
    @DisplayName("createRandomNumbers의 매개변수값이 1이상 입력되지 않았을때 exception 처리.")
    void createRandomNumbers_lessThan1(int size) {
        assertThatThrownBy(() -> {service.createRandomNumbers(size);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.LESS_THAN_1.getText());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("createRandomNumbers의 매개변수로 전달할 값 만큼 Array 사이즈를 생성하는지 확인.")
    void createRandomNumbers_sizeTest(int size) {
        BaseNumbers baseNumbers = service.createRandomNumbers(size);

        assertThat(baseNumbers.getNumbers())
            .hasSize(size);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사용자가 빈값을 넣었을때 exception을 발생 시키는지 확인.")
    void validate_nullAndEmpty(String numbers) {
        assertThatThrownBy(() -> {service.validate(numbers);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.NUMBER_REQUIRED.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2345", "25"})
    @DisplayName("사용자가 게임에 사용 하기로한 숫자 갯수에 맞쳐서 입력하지 않았을때 exception을 발생 시키는지 확인.")
    void validate_limitLength(String numbers) {
        service.startGame(Constants.BASEBALL_DEFAULT_NUMBER_SIZE);

        assertThatThrownBy(() -> {service.validate(numbers);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(
                Message.ONLY_LIMIT_CHARACTERS.getTextWithWord(
                    String.valueOf(Constants.BASEBALL_DEFAULT_NUMBER_SIZE)));
    }


}
