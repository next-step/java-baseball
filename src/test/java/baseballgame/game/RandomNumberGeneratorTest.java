package baseballgame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomNumberGeneratorTest {

    @DisplayName("정수 범위와 사이즈로 랜덤한 정수 리스트를 생성 할 수 있다.")
    @Test
    public void generateRandomNumberListSuccessTest() {
        // given
        final int start = 1;
        final int end = 9;
        final int size = 3;

        // when
        final List<Integer> list = RandomNumberGenerator.generateRandomNumberList(start, end, size);

        // then
        final HashSet<Integer> set = new HashSet<>(list);
        assertThat(list.size()).isEqualTo(set.size());
        assertThat(list).allMatch(num -> num >= start && num <= end);
    }

    @ParameterizedTest(name = "랜덤 정수 리스트 생성시, 정수 범위는 upperBound 가 lowerBound 보다 커야하고, size 는 0보다 커야한다.")
    @CsvSource(value = {"2:1:3", "1:9:0"}, delimiter = ':')
    public void generateRandomNumberListFailTest(int lowerBound, int upperBound, int size) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RandomNumberGenerator.generateRandomNumberList(lowerBound, upperBound, size));
    }

}
