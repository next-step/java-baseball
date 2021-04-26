package domain.baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class BaseballGroupTest {


    @ParameterizedTest
    @ValueSource(strings = {"1234", "4567", "7891"})
    void baseball_group_validate_number_size(String baseballValues){
        assertThatThrownBy(() -> {
            BaseballGroup baseballGroup = new BaseballGroup(baseballValues);
            BaseballGroup.validateNumberSize(baseballGroup.getBaseballList());
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(String.format("야구 게임의 입력 숫자는 %d 개를 입력해주세요.",BaseballGroup.getRandomLength()));

    }

    @ParameterizedTest
    @ValueSource(strings = {"122", "525", "331"})
    void validate_duplicate_number_value(String baseballValues){
        assertThatThrownBy(() -> {
            BaseballGroup baseballGroup = new BaseballGroup(baseballValues);
            BaseballGroup.validateDuplicateNumberValue(baseballGroup.getBaseballList());
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("야구 게임의 입력 숫자는 중복 될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void create_baseball_group(String baseballValues){
        BaseballGroup baseballGroup = new BaseballGroup(baseballValues);
        assertThat(baseballGroup.baseballValueSize()).isEqualTo(3);

    }
}
