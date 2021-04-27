package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BatTest {

    @DisplayName("배트 입력을 받아 등록할 수 있다.")
    @Test
    void create() {
        List<BallNumber> ballNumber1 = Arrays.asList(new BallNumber(4), new BallNumber(5), new BallNumber(3));
        BallNumbers ballNumbers = new BallNumbers(ballNumber1);
        Bat bat = new Bat(ballNumbers);

        assertThat(bat.getShots().size()).isEqualTo(3);
    }

}
