package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OpponentTest {


    @Test
    public void select_value_three_number_test() {
        for (int i = 0; i < 10_000; i++) {
            //Given
            Opponent opponent = new Opponent();

            //When
            opponent.selectValue();
            String value = opponent.getValue();
            //Then
            Assertions.assertEquals(value.length(), 3);
        }
    }

    @Test
    public void select_value_different_each_others_test() {
        for (int i = 0; i < 10_000; i++) {
            //Given
            Opponent opponent = new Opponent();

            //When
            opponent.selectValue();
            String value = opponent.getValue();
            //Then
            Assertions.assertNotEquals(value.charAt(0), value.charAt(1));
            Assertions.assertNotEquals(value.charAt(0), value.charAt(2));
            Assertions.assertNotEquals(value.charAt(1), value.charAt(2));
        }
    }

    @Test
    void judge_strike_value_three_correct() {
        //Given
        Opponent opponent = new Opponent("123");

        //When
        opponent.judgeGame("123");

        //Then
        Assertions.assertEquals(opponent.getStrikeCnt(), 3);

    }

    @Test
    void judge_strike_value_two_correct() {
        //Given
        Opponent opponent = new Opponent("123");

        //When
        opponent.judgeGame("124");

        //Then
        Assertions.assertEquals(opponent.getStrikeCnt(), 2);
    }

    @Test
    void judge_strike_value_one_correct() {
        //Given
        Opponent opponent = new Opponent("123");

        //When
        opponent.judgeGame("154");

        //Then
        Assertions.assertEquals(opponent.getStrikeCnt(), 1);
    }

    @Test
    void judge_strike_value_zero_correct() {
        //Given
        Opponent opponent = new Opponent("123");

        //When
        opponent.judgeGame("254");

        //Then
        Assertions.assertEquals(opponent.getStrikeCnt(), 0);
    }

}
