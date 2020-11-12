package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallMakerTest {
    @DisplayName("1-9 사이 숫자 3개를 생성한다.")
    @Test
    void getThreeNumbers() {
        //given
        BallMaker ballMaker = new BallMaker();

        //when
        List<Ball> threeNumbers = ballMaker.getThreeNumbers();

        //then
        assertEquals(threeNumbers.size(), 3);
    }
}
