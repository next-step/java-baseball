package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballGameTest {

    @Test
    void makeRandomNumber() {
        Set<Integer> randomSet = new HashSet<>();
        while (randomSet.size() < 3) {
            randomSet.add((int) (Math.random() * (9 - 1)) + 1);
        }
        // 난수 생성 자리수
        assertThat(randomSet).hasSize(3);

        int random = 0;
        int digits = 100;
        int[] testRandoms = new int[3];
        int testIndex = 0;
        Iterator iterator = randomSet.iterator();
        while (iterator.hasNext()) {
//            random += (int) iterator.next() * digits;
            testRandoms[testIndex++] = (int) iterator.next();
            digits /= 10;
        }

        assertThat(randomSet).containsExactly(testRandoms[0], testRandoms[1], testRandoms[2]);
    }

    @ParameterizedTest
    @ValueSource(ints = {135, 143, 153, 123})
    void countStrike(int input) {
        int random = 123;

        int strike = 0;
        while (input > 0) {
            strike += random % 10 == input % 10 ? 1 : 0;
            random /= 10;
            input /= 10;
        }

        assertThat(strike).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {135, 143, 153, 123})
    void countBall(int input) {
        int random = 123;

        int ball = 0;
        List<Integer> randomList = new ArrayList<>();
        List<Integer> inputList = new ArrayList<>();

        while (input > 0) {
            randomList.add(random % 10);
            inputList.add(input % 10);

            random /= 10;
            input /= 10;
        }

        for (int i = 0; i < inputList.size(); i++) {
            if (randomList.get(i) == inputList.get(i)) {
                continue;
            }
            if (randomList.contains(inputList.get(i))) {
                ball++;
            }
        }

        assertThat(ball).isEqualTo(0);
    }

}
