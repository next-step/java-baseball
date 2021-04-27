import baseball.domain.Score;
import baseball.exception.IllegalPositionException;
import baseball.service.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("무작위 생성된 숫자가 세자리 수인지 확인")
    void random_three_digits() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = game.getClass().getDeclaredMethod("createRandomNumber");
        method.setAccessible(true);
        for (int i = 0; i <100000; i++) {
            int number = (int) method.invoke(game);
            assertThat(String.valueOf(number)).hasSize(3);
        }
    }

    @Test
    @DisplayName("첫번째 자리수가 0을 제외한 1-9 숫자를 포함하는지 확인")
    void third_number_range_between_one_and_nine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertThat(getIntegers(3)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9).doesNotContain(0);
    }

    @Test
    @DisplayName("두번째 자리수가 0-9 숫자를 포함하는지 확인")
    void second_number_range_between_zero_and_nine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertThat(getIntegers(2)).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    @DisplayName("세번째 자리수가 0-9 숫자를 포함하는지 확인")
    void first_number_range_between_zero_and_nine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertThat(getIntegers(1)).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    @DisplayName("중복된 숫자를 포함하는지 확인")
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
    @DisplayName("세자리 모두 스트라이크 처리 확인, 전체 자리와 숫자 모두 맞춘 경우")
    void all_strike() {
        assertPlay(game.play(123), 3, 0);
    }

    @Test
    @DisplayName("일부 스트라이크 처리 확인, 일부 자리와 숫자 모두 맞춘 경우")
    void some_strike() {
        assertPlay(game.play(145), 1, 0);
        assertPlay(game.play(125), 2, 0);
    }

    @Test
    @DisplayName("낫싱 처리 확인, 모든 숫자 틀린 경우")
    void nothing() {
        assertPlay(game.play(456), 0, 4);
    }

    @Test
    @DisplayName("원볼 처리 확인, 숫자 하나 맞은 경우")
    void one_ball() {
        assertPlay(game.play(451), 0, 1);
    }

    @Test
    @DisplayName("여러개 볼 처리 확인, 숫자는 맞았지만 자리가 틀린 경우")
    void many_ball() {
        assertPlay(game.play(431), 0, 2);
        assertPlay(game.play(231), 0, 3);
    }

    @Test
    @DisplayName("스트라이크와 볼이 혼합되어 있는 경우 확인")
    void one_strike_two_ball() {
        assertPlay(game.play(132), 1, 2);
    }

    private Set<Integer> getIntegers(int position) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = game.getClass().getDeclaredMethod("createRandomNumber");
        method.setAccessible(true);
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < 1000000; i++) {
            int number = (int) method.invoke(game);
            sets.add(getNumberAtPos(number, position));
        }
        return sets;
    }

    private int getNumberAtPos(int number, int position) {
        if (position == 3)
            return number / 100;
        else if ((position == 2))
            return number / 10 % 10;
        else if (position == 1)
            return number % 10;
        throw new IllegalPositionException();
    }

    private void assertPlay(Score score, int strike, int ball) {
        assertThat(score.getStrike()).isEqualTo(strike);
        assertThat(score.getBall()).isEqualTo(ball);
    }

}
