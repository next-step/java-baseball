package baseball;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    String answer = "";
    Random random = new Random();
    int strike;
    int ball;

    @Test
    void main() {
    }

    @Test
    void initGame() {

        random.setSeed(System.currentTimeMillis());

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while(set.size() != 3) {
            set.add(random.nextInt(9) + 1);
        }

        for (int number : set) {
            answer += number;
        }

        assertEquals(3, set.size());
        assertEquals(3, answer.length());
    }

    @Test
    void playGame() {
        String input = "123";
        answer = "135";
        strike = 0;
        ball = 0;

        submitInput(input);

        assertEquals(1, strike);
        assertEquals(1, ball);
    }

    void submitInput(String input) {
        for(int i=0; i < input.length(); i++) {
            validate(i, input.charAt(i));
        }
    }

    void validate(int index, char number) {
        int location = answer.indexOf(number);

        if (location == index) {
            strike += 1;
            return;
        }

        if (location > -1) {
            ball += 1;
            return;
        }
    }
}