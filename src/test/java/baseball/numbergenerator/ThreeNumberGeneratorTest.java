package baseball.numbergenerator;

import baseball.BaseballGameModel;
import baseball.Target;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.RandomUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ThreeNumberGeneratorTest {

    ThreeNumberGenerator sut;

    @BeforeEach
    void setUp() {
        sut = new ThreeNumberGenerator();
    }

    @ParameterizedTest(name = "랜덤유틸_성공_테스트 > {argumentsWithNames}")
    @CsvSource(value = {"0:1", "0:10", "0:100"}, delimiter = ':')
    void 랜덤유틸_성공_테스트(int start, int end) {
        assertThat(RandomUtils.nextInt(start, end)).isBetween(start, end);
    }

    @ParameterizedTest(name = "랜덤유틸_실패_테스트 > {argumentsWithNames}")
    @CsvSource(value = {"1:0", "-1:10"}, delimiter = ':')
    void 랜덤유틸_실패_테스트(int start, int end) {
        assertThatThrownBy(() -> RandomUtils.nextInt(start, end)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤으로_숫자_3개_를_만든다() {
        Target numbers = sut.create();
        List<Character> value = numbers.getValue();
        int size = value.size();
        assertThat(size).isEqualTo(BaseballGameModel.NUMBER_SIZE);
        for (Character actual : value) {
            assertThat(Character.isDigit(actual)).isTrue();
        }
    }

    @Test
    void 랜덤으로_만들어진숫자는_각_자리_수가_1_9까지의_숫자를_가진다() {
        Target numbers = sut.create();
        List<Character> value = numbers.getValue();
        int size = value.size();
        assertThat(size).isEqualTo(BaseballGameModel.NUMBER_SIZE);

        for (Character actual : value) {
            assertThat(actual).isBetween('1', '9');
        }
    }

    @Test
    void 중복의_숫자가_출력되지_않는다() {
        for (int i = 0; i < 1000; i++) {
            Target target = sut.create();
            checkIsDuplicateNumber(target);
        }
    }

    private void checkIsDuplicateNumber(Target numbers) {
        List<Character> value = numbers.getValue();
        Set<Character> set = new HashSet<>(value);
        assertThat(set.size()).isEqualTo(BaseballGameModel.NUMBER_SIZE);
        set.clear();
    }
}