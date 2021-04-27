package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    @DisplayName("nothing 테스트")
    void nothingTest(){
        int number = 123;
        Numbers numbers = new Numbers(number);
        Hitter hitter = new Hitter(numbers);
        Referee referee = new Referee(hitter);

        referee.check(new Numbers(456));

        assertThat(referee.strike()).isEqualTo(0);
        assertThat(referee.ball()).isEqualTo(0);


    }



    @Test
    @DisplayName("3 strike 테스트")
    void threeStrikeTest(){
        int number = 123;
        Numbers numbers = new Numbers(number);
        Hitter hitter = new Hitter(numbers);
        Referee referee = new Referee(hitter);

        referee.check(new Numbers(123));

        assertThat(referee.strike()).isEqualTo(3);
        assertThat(referee.ball()).isEqualTo(0);


    }

    @Test
    @DisplayName("1 strike  2 ball 테스트")
    void onsStrikeTwoballTest(){
        int number = 123;
        Numbers numbers = new Numbers(number);
        Hitter hitter = new Hitter(numbers);
        Referee referee = new Referee(hitter);

        referee.check(new Numbers(132));

        assertThat(referee.strike()).isEqualTo(1);
        assertThat(referee.ball()).isEqualTo(2);
    }



}
