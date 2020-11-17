package baseballgame.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerGeneratorTest {

    @DisplayName("서로 다른 난수 3개 생성 확인")
    @Test
    void generateRandomInt(){
        //given
        List<Integer> numberPool =  Arrays.asList(1,2,3,4,5,6,7,8,9);
        Collections.shuffle(numberPool);

        //when
        List<Integer> answer = numberPool.subList(0, 3);

        //then
        for(int number : answer){
            assertThat(numberPool).contains(number);
        }
        assertThat(answer).hasSize(3);
    }


}