package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InningTest {

    @DisplayName("새 게임이 시작하였을때 랜덤하게 3개의 숫자가 생성")
    @Test
    public void newInningTest(){
        //when
        Inning inning = Inning.newInning();
        int[] answer = inning.getAnswer();  //Test를 위해 Getter생성

        //then
        assertThat(answer[0]).isNotEqualTo(answer[1]);
        assertThat(answer[0]).isNotEqualTo(answer[2]);
        assertThat(answer[1]).isNotEqualTo(answer[2]);

        //when
        Inning newInning = Inning.newInning();
        int[] newAnswer = newInning.getAnswer();

        //then
        assertThat(answer).isNotEqualTo(newAnswer);
    }

    @DisplayName("결과값 정상 출력 확인")
    @Test
    public void pitchTest(){
        //given
        int[] answer = new int[]{1, 2, 3};
        Inning inning = new Inning(answer);
        String nothing = "456";
        String balls = "312";
        String oneStrike = "178";
        String threeStrikes = "123";

        //when
        boolean isOver = inning.pitch(nothing);
        //then
        assertFalse(isOver);

        //when
        isOver = inning.pitch(balls);
        //then
        assertFalse(isOver);

        //when
        isOver = inning.pitch(oneStrike);
        //then
        assertFalse(isOver);

        //when
        isOver = inning.pitch(threeStrikes);
        //then
        assertTrue(isOver);
    }


}