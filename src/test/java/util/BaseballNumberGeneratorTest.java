package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberGeneratorTest {

    @Test
    @DisplayName("베이스볼 생성 번호의 갯수가 3개인지 확인 테스트")
    void generateBaseballNumberTest() {
        List<Integer> generatedNumbers = BaseballNumberGenerator.generator();
        Set<Integer> numberSet = new HashSet<>(generatedNumbers);

        generatedNumbers.stream().forEach(System.out::print);
        assertThat(numberSet).hasSize(3);
        assertThat(BaseballNumberGenerator.generator()).hasSize(3);
    }
}
