package logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameCoreLogicTest {
    @Test
    public void 랜덤번호를_생성하면_특정갯수의_랜덤번호가_생성된다() {
        // given
        BaseballGameCoreLogic baseballGameCoreLogic = new BaseballGameCoreLogic();

        // when
        baseballGameCoreLogic.generateAnswer();
        List<Integer> answer = baseballGameCoreLogic.getAnswer();

        // then
        assertEquals(answer.size(), Answer.ANSWER_SIZE);
        for (Integer v:answer) {
            System.out.println("v = " + v);
            assertEquals (v>=Answer.ANSWER_LOWER_BOUND_NUMBER && v<=Answer.ANSWER_UPPER_BOUND_NUMBER, true);
        }
    }


}