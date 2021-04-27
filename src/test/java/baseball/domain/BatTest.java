package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BatTest {

    @DisplayName("배트 입력을 받아 등록할 수 있다.")
    @Test
    void create() {
        Bat bat = new Bat();

        bat.addShot(new BallNumber(3));
        bat.addShot(new BallNumber(4));
        bat.addShot(new BallNumber(5));

        assertThat(bat.getShots().size()).isEqualTo(3);
    }

    @DisplayName("중복 입력을 받을시 에러를 던진다.")
    @Test
    void createWithDuplicateBall() {
        Bat bat = new Bat();

        bat.addShot(new BallNumber(3));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bat.addShot(new BallNumber(3)));
    }

    @DisplayName("최대 입력 갯수 초과시 에러를 던진다.")
    @Test
    void createWithExceedBall() {
        Bat bat = new Bat();

        bat.addShot(new BallNumber(1));
        bat.addShot(new BallNumber(2));
        bat.addShot(new BallNumber(3));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bat.addShot(new BallNumber(4)));
    }
}
