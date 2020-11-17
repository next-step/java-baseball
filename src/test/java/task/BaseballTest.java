package task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballTest {

    private Baseball baseball;

    @BeforeEach
    void setUp() {
        baseball = new Baseball();
    }

    @Test
    @DisplayName("컴퓨터 숫자 자동 생성 빈 객체 및 사이즈 체크")
    void createComputerDataCheck() {
        baseball.computerNumberInput();
        assertThat(baseball.computer).isNotEmpty().hasSize(3);
    }

    @Test
    @DisplayName("유저 컬렉션 빈 객체 및 사이즈 체크")
    void createUserDataCheck() {
        while (baseball.user.size() < baseball.COLLECTION_MAXIMUM_LENGTH)
            baseball.user.add(baseball.random.nextInt(10)+1);

        assertThat(baseball.user).isNotEmpty().hasSize(3);
    }

    @Test
    @DisplayName("스트라이크 및 볼 체크 정상적으로 되는지 확인")
    void strikeAndBallCompare() {
        baseball.user.addAll(Arrays.asList(1,2,3));
        baseball.computer.addAll(Arrays.asList(1,2,3));
        baseball.compare();
        assertEquals(3,baseball.strike);
        assertEquals(0,baseball.ball);

        baseball.user.clear();
        baseball.strike = 0;
        baseball.user.addAll(Arrays.asList(3,1,2));
        baseball.compare();
        assertEquals(3,baseball.ball);
        assertEquals(0,baseball.strike);

        baseball.user.clear();
        baseball.ball = 0;
        baseball.user.addAll(Arrays.asList(4,5,6));
        baseball.compare();
        assertEquals(0,baseball.ball);
        assertEquals(0,baseball.strike);

    }
}