package baseball;

import static constant.BaseballSpecification.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGenerator {

    private static final int DEFAULT_POSITION = 0;
    private static final int ASCII_ZERO = 48;

    public Baseballs createRandomBaseballs() {
        List<Baseball> basket = new ArrayList<>();
        for (int number = MIN_NUMBER.getValue(); number <= MAX_NUMBER.getValue(); number++) {
            basket.add(new Baseball(number));
        }

        Collections.shuffle(basket);

        return new Baseballs(basket.subList(DEFAULT_POSITION, MAX_BASEBALLS.getValue()));
    }

    public Baseballs createBaseballs(String answer) {
        List<Baseball> basket = new ArrayList<>();
        for (int i = 0; i < MAX_BASEBALLS.getValue(); i++) {
            basket.add(new Baseball(answer.charAt(i) - ASCII_ZERO));
        }

        return new Baseballs(basket);
    }

}
