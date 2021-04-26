package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

    @Test
    public void 임의의_수_선택() {
        final List<Integer> randomNumber = RandomNumber.createRandomNumber();

        StringBuilder numStr = new StringBuilder();
        for (int num : randomNumber) {
            numStr.append(num);
        }

        int num = Integer.parseInt(numStr.toString());

        assertThat(num).isBetween(1, 999);
    }

}