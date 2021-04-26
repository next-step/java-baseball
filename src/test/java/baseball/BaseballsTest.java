package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballsTest {

    @DisplayName("두 야구공 세트를 비교하여 스트라이크 개수를 센다.")
    @Test
    void countStrike() {
        List<Baseball> basket1 = new ArrayList<>();
        basket1.add(new Baseball(1));
        basket1.add(new Baseball(2));
        basket1.add(new Baseball(3));

        List<Baseball> basket2 = new ArrayList<>();
        basket2.add(new Baseball(1));
        basket2.add(new Baseball(2));
        basket2.add(new Baseball(4));

        Baseballs baseballs1 = new Baseballs(basket1);
        Baseballs baseballs2 = new Baseballs(basket2);

        int strike = baseballs1.countStrike(baseballs2);

        assertThat(strike).isEqualTo(2);
    }

    @DisplayName("두 야구공 세트를 비교하여 볼 개수를 센다.")
    @Test
    void countBall() {
        List<Baseball> basket1 = new ArrayList<>();
        basket1.add(new Baseball(1));
        basket1.add(new Baseball(2));
        basket1.add(new Baseball(3));

        List<Baseball> basket2 = new ArrayList<>();
        basket2.add(new Baseball(3));
        basket2.add(new Baseball(1));
        basket2.add(new Baseball(2));

        Baseballs baseballs1 = new Baseballs(basket1);
        Baseballs baseballs2 = new Baseballs(basket2);

        int ball = baseballs1.countBall(baseballs2);

        assertThat(ball).isEqualTo(3);
    }

}