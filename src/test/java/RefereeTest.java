import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    Referee referee;
    List<Integer> thoughtNumber;
    List<Integer> presentationNumber;

    @BeforeEach
    void setUp() {
        referee = new Referee();
        this.thoughtNumber = new ArrayList<>(Arrays.asList(4,2,5));
        this.presentationNumber = new ArrayList<>(Arrays.asList(5,2,4));
    }

    @Test
    void countStrike() {
        // when
        for (int index = 0; index < presentationNumber.size(); index++) {
            this.referee.countStrike(thoughtNumber.get(index) , presentationNumber.get(index));
        }

        // then
        assertThat(this.referee.getStrike()).isEqualTo(1);
    }

    @Test
    void countBalls() {
        // when
        for (int index = 0; index < presentationNumber.size(); index++) {
            this.referee.countBalls(thoughtNumber, index, presentationNumber.get(index));
        }

        // then
        assertThat(this.referee.getBalls()).isEqualTo(2);
    }
}
