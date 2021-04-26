package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    public void 볼_확인() {
        final List<Integer> randomNumber = RandomNumber.createRandomNumber();
        final List<Integer> input = RandomNumber.createRandomNumber();

        final int count = Ball.checkBall(input, randomNumber);

        assertThat(count).isBetween(0, 3);
        System.out.println("input: " + input + " randomNumber: " + randomNumber);
        System.out.println(count + "볼");
    }

}