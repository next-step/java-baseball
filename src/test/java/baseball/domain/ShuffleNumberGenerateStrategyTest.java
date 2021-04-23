package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ShuffleNumberGenerateStrategyTest {

    @Test
    @DisplayName("게임숫자 생성 - 갯수검증")
    void generateNumber_Count() {
        // given
        ShuffleNumberGenerateStrategy strategy = new ShuffleNumberGenerateStrategy();

        // when
        List<Integer> integers = strategy.generateNumbers();

        // then
        assertThat(BaseballNumbers.SIZE).isEqualTo(integers.size());
    }

    @Test
    @DisplayName("게임숫자 생성 - 중복은 존재하지 않음")
    void generate_hasNotDuplicate() {
        // given
        ShuffleNumberGenerateStrategy strategy = new ShuffleNumberGenerateStrategy();

        // when
        List<Integer> integers = strategy.generateNumbers();
        Set<Integer> integerSet = new HashSet<>(integers);

        // then
        assertThat(integers.size()).isEqualTo(integerSet.size());
    }
}