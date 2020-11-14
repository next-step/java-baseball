package game.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallNumbersGeneratorTest {

    @Test
    @DisplayName("범위 내의 임의의 랜덤 숫자 생성")
    void generateNumberInRange() {
        List<BaseBallNumber> numbers = BaseBallNumberGenerator.shuffleAndGet();
        for (BaseBallNumber number : numbers) {
            assertThat(number.getNumber()).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("중복 없는 숫자를 생성")
    void generateNumberWithoutDuplicate() {
        List<BaseBallNumber> lottoNumbers = BaseBallNumberGenerator.shuffleAndGet();
        Set<Integer> numberSet = new HashSet<>();
        for (BaseBallNumber lottoNumber : lottoNumbers) {
            numberSet.add(lottoNumber.getNumber());
        }

        assertThat(lottoNumbers.size()).isEqualTo(numberSet.size()).isEqualTo(3);
    }
}
