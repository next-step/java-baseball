import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BaseBallTest {

    @Test
    @DisplayName("중복 없는 3자리 숫자 정답 확인")
    void checkAnswer(){
        BaseBall baseBall = new BaseBall();
        String answer = baseBall.getAnswer();
        String[] arrAnswer = answer.split("");
        assertAll(
                ()->assertNotNull(answer),
                ()->assertEquals(answer.length(),3),
                ()->assertNotEquals(arrAnswer[0],arrAnswer[1], arrAnswer[2])
        );


    }
}
