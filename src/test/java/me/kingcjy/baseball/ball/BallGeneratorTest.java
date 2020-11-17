package me.kingcjy.baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
public class BallGeneratorTest {

    @ParameterizedTest
    @DisplayName("서로다른 랜덤한 숫자 digit개를 가진 Ball 객체를 만들어 반환한다.")
    @ValueSource(ints = {3, 4, 5})
    public void generateTest(int digit) {
        BallGenerator ballGenerator = new BallGenerator();
        Ball ball = ballGenerator.generate(digit);

        List<BallNumber> ballNumbers = ball.getNumbers();
        int[] numbers = ballNumbersToIntArray(ballNumbers);
        int uniqueCount = getUniqueCount(numbers);

        assertThat(numbers.length).isEqualTo(uniqueCount);
    }

    private int getUniqueCount(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            set.add(numbers[i]);
        }
        return set.size();
    }

    private int[] ballNumbersToIntArray(List<BallNumber> ballNumbers) {
        int[] result = new int[ballNumbers.size()];

        for (int i = 0; i < ballNumbers.size(); i++) {
            result[i] = ballNumbers.get(i).getValue();
        }

        return result;
    }

}
