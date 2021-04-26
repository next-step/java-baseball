package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {

    @Test
    @DisplayName("같은 자리의 수 세기")
    void equalsCount() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();

        // when
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers base = new BaseballNumbers(numbersBase);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("123");
        BaseballNumbers target = new BaseballNumbers(numbersTarget);

        // then
        assertThat(3).isEqualTo(base.equalsCount(target));
    }

    @Test
    @DisplayName("다른 자리의 수 세기")
    void containsCount() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();

        // when
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(3, 1, 2));
        BaseballNumbers base = new BaseballNumbers(numbersBase);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("123");
        BaseballNumbers target = new BaseballNumbers(numbersTarget);

        // then
        assertThat(3).isEqualTo(base.containsCount(target));
    }

    @Test
    @DisplayName("숫자가 서로 다른 경우")
    void notEquals() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();

        // when
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(3, 1, 2));
        BaseballNumbers base = new BaseballNumbers(numbersBase);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("789");
        BaseballNumbers target = new BaseballNumbers(numbersTarget);

        // then
        assertThat(0).isEqualTo(base.equalsCount(target));
        assertThat(0).isEqualTo(base.containsCount(target));
    }

}