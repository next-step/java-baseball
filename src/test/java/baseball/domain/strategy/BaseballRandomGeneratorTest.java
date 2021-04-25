package baseball.domain.strategy;

import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("야구숫자 랜덤생성 전략 기능 테스트")
class BaseballRandomGeneratorTest {

    private BaseballGenerator baseballGenerator;

    @BeforeEach
    void setup() {
        baseballGenerator = new BaseballRandomGenerator();
    }


    @DisplayName("야구숫자 생성을 반복하더라도 결과는 항상 서로다른 3개이다.")
    @Test
    void generateTest() {
        //when, then
        for (int i = 0; i < 100; i++) {
            BallNumbers generated = baseballGenerator.generate();
            assertThat(generated.size()).isEqualTo(3);
            assertThat(existsDuplicateNumber(generated)).isFalse();
        }
    }

    private boolean existsDuplicateNumber(BallNumbers numbers) {
        Set<BallNumber> numbersSet = new HashSet<>();

        for (int index = 0; index < numbers.size(); index++) {
            numbersSet.add(numbers.get(index));
        }

        return numbers.size() != 3;
    }


}
