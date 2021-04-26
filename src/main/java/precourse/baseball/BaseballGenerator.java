package precourse.baseball;

import static precourse.constant.BaseballSpecification.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGenerator {

    private static final int DEFAULT_POSITION = 0;
    private static final int ASCII_ZERO = 48;

    public Baseballs createRandomBaseballs() {
        List<precourse.baseball.Baseball> basket = new ArrayList<>();
        for (int number = MIN_NUMBER.getValue(); number <= MAX_NUMBER.getValue(); number++) {
            basket.add(new precourse.baseball.Baseball(number));
        }

        Collections.shuffle(basket);

        return new precourse.baseball.Baseballs(basket.subList(DEFAULT_POSITION, MAX_BASEBALLS.getValue()));
    }

    public precourse.baseball.Baseballs createBaseballs(String answer) {
        List<precourse.baseball.Baseball> basket = new ArrayList<>();
        for (int i = 0; i < MAX_BASEBALLS.getValue(); i++) {
            basket.add(new precourse.baseball.Baseball(answer.charAt(i) - ASCII_ZERO));
        }

        return new precourse.baseball.Baseballs(basket);
    }

}
