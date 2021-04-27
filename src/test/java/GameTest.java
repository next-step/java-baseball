import baseball.domain.Score;
import baseball.exception.IllegalPositionException;
import baseball.service.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(123);
    }

    @Test
    void random_three_digits() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = game.getClass().getDeclaredMethod("createRandomNumber");
        method.setAccessible(true);
        for (int i = 0; i <100000; i++) {
            int number = (int) method.invoke(game);
            assertThat(String.valueOf(number)).hasSize(3);
        }
    }

    @Test
    void all_strike() {
        assertPlay(game.play(123), 3, 0);
    }

    @Test
    void some_strike() {
        assertPlay(game.play(145), 1, 0);
        assertPlay(game.play(125), 2, 0);
    }

    @Test
    void nothing() {
        assertPlay(game.play(456), 0, 4);
    }

    @Test
    void one_ball() {
        assertPlay(game.play(451), 0, 1);
    }

    @Test
    void many_ball() {
        assertPlay(game.play(431), 0, 2);
        assertPlay(game.play(231), 0, 3);
    }

    @Test
    void one_strike_two_ball() {
        assertPlay(game.play(132), 1, 2);
    }

    @Test
    void check_duplicate_random_number() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = game.getClass().getDeclaredMethod("createRandomNumber");
        method.setAccessible(true);
        for (int i = 0; i < 1000000; i++) {
            int number = (int) method.invoke(game);
            Set<Integer> sets = new HashSet<>();
            sets.add(number / 100);
            sets.add(number / 10 % 10);
            sets.add(number % 10);
            assertThat(sets).hasSize(3);
        }
    }

    @Test
    void third_number_range_between_one_and_nine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Set<Integer> sets = getIntegers(3);
        assertThat(sets).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9).doesNotContain(0);
    }

    @Test
    void second_number_range_between_zero_and_nine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Set<Integer> sets = getIntegers(2);
        assertThat(sets).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    void first_number_range_between_zero_and_nine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Set<Integer> sets = getIntegers(1);
        assertThat(sets).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private Set<Integer> getIntegers(int pos) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = game.getClass().getDeclaredMethod("createRandomNumber");
        method.setAccessible(true);
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < 1000000; i++) {
            int number = (int) method.invoke(game);
            sets.add(getNumberAtPos(number, pos));
        }
        return sets;
    }

    private int getNumberAtPos(int number, int pos) {
        if (pos == 3)
            return number / 100;
        else if ((pos == 2))
            return number / 10 % 10;
        else if (pos == 1)
            return number % 10;
        throw new IllegalPositionException();
    }

    private void assertPlay(Score score, int strike, int ball) {
        assertThat(score.getStrike()).isEqualTo(strike);
        assertThat(score.getBall()).isEqualTo(ball);
    }

}
