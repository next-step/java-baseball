package domain;

import domain.exceptions.BaseballNumberDuplicatedException;
import domain.exceptions.OutOfBoundBaseballNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MockBaseballNumbersGeneratorTests {
    @DisplayName("1 ~ 9 중 세개의 숫자를 입력받아서 중복 없는 요소 3개인 BaseballNumber 컬렉션 생성")
    @Test
    void generateTest() {
        BaseballNumbersGenerator baseballNumbersGenerator = new MockBaseballNumbersGenerator(1, 2, 3);

        BaseballNumbers baseballNumbers = baseballNumbersGenerator.generate();

        assertThat(baseballNumbers.size()).isEqualTo(3);
        assertThat(baseballNumbers.contains(BaseballNumber.ONE)).isTrue();
        assertThat(baseballNumbers.contains(BaseballNumber.TWO)).isTrue();
        assertThat(baseballNumbers.contains(BaseballNumber.THREE)).isTrue();
    }

    @DisplayName("중복된 번호가 있는 상태로 생성 시도 시 예외 발생")
    @Test
    void generateFailByDupTest() {
        BaseballNumbersGenerator baseballNumbersGenerator = new MockBaseballNumbersGenerator(1, 1, 3);

        assertThatThrownBy(baseballNumbersGenerator::generate).isInstanceOf(BaseballNumberDuplicatedException.class);
    }

    @DisplayName("생성 가능한 범위를 벗어난 숫자로 생성 시도 시 예외 발생")
    @Test
    void generateFailByOutOfBoundTest() {
        BaseballNumbersGenerator baseballNumbersGenerator =
                new MockBaseballNumbersGenerator(11, 12, 13);

        assertThatThrownBy(baseballNumbersGenerator::generate).isInstanceOf(OutOfBoundBaseballNumberException.class);
    }
}
