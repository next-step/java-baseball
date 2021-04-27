package numbaseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.*;
import java.util.*;

public class PlayTest {

    Play play = new Play();

    @Test
    public void createPlayNumberTest() {
        List<Integer> playNumberList1 = play.createPlayNumber();
        List<Integer> playNumberList2 = play.createPlayNumber();

        assertThat(playNumberList1).isNotNull()
                                   .hasSize(3)
                                   .isNotEqualTo(playNumberList2)
                                   .hasOnlyElementsOfType(Integer.class);
    }

    @Test
    public void judgeTest() {
        Integer[] arrPlayNumber = {1,2,3};
        Integer[] arrUserNumber = {2,4,3};

        List<Integer> playNumber = Arrays.asList(arrPlayNumber);
        List<Integer> userNumber = Arrays.asList(arrUserNumber);
        Map<String,Object> playResult = play.judge(playNumber, userNumber);
        assertThat(playResult).extracting("strike","ball").contains(1,1);
    }

    @Test
    public void isEndGameTest(){
        Map<String,Object> playResult = new HashMap<String,Object>();
        playResult.put("strike", "3");
        boolean isEnd = play.isEndGame(playResult);
        assertThat(isEnd).isFalse();

    }

}
