package domain;

import domain.exceptions.BaseballNumberDuplicatedException;
import domain.exceptions.OutOfBoundBaseballNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StaticBaseballNumberGeneratorTests {
    @DisplayName("1 ~ 9 중 세개의 숫자를 입력받아서 중복 없는 요소 3개인 BaseballNumber 컬렉션 생성")
    @Test
    void generateTest() {
        BaseballNumberGenerator baseballNumberGenerator = new StaticBaseballNumberGenerator(1, 2, 3);

        Set<BaseballNumber> baseballNumbers = baseballNumberGenerator.generate();

        assertThat(baseballNumbers.size()).isEqualTo(3);
        assertThat(baseballNumbers).contains(BaseballNumber.ONE);
        assertThat(baseballNumbers).contains(BaseballNumber.TWO);
        assertThat(baseballNumbers).contains(BaseballNumber.THREE);
    }

    @DisplayName("중복된 번호가 있는 상태로 생성 시도 시 예외 발생")
    @Test
    void generateFailByDupTest() {
        BaseballNumberGenerator baseballNumberGenerator = new StaticBaseballNumberGenerator(1, 1, 3);

        assertThatThrownBy(baseballNumberGenerator::generate).isInstanceOf(BaseballNumberDuplicatedException.class);
    }

    @DisplayName("생성 가능한 범위를 벗어난 숫자로 생성 시도 시 예외 발생")
    @Test
    void generateFailByOutOfBoundTest() {
        BaseballNumberGenerator baseballNumberGenerator =
                new StaticBaseballNumberGenerator(11, 12, 13);

        assertThatThrownBy(baseballNumberGenerator::generate).isInstanceOf(OutOfBoundBaseballNumberException.class);
    }
}
