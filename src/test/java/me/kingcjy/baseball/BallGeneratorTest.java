package me.kingcjy.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
public class BallGeneratorTest {

    @Test
    @DisplayName("서로다른 랜덤한 숫자 3개를 가진 Ball 객체를 만들어 반환한다.")
    public void generateTest() {
        BallGenerator ballGenerator = new BallGenerator();
        Ball ball = ballGenerator.generate(3);

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
