package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StrikeTest {

    @Test
    public void 스트라이크_확인() {
        final List<Integer> randomNumber = RandomNumber.createRandomNumber();
        final List<Integer> input = RandomNumber.createRandomNumber();

        final int count = Strike.checkStrike(input, randomNumber);

        assertThat(count).isBetween(0, 3);
        System.out.println("input: " + input + " randomNumber: " + randomNumber);
        System.out.println(count + " 스트라이크");

    }

}