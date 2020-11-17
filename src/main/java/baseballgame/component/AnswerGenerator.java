package baseballgame.component;

import java.util.*;

public class AnswerGenerator {

    /**
     * @return 야구게임 정답 생성
     */
    public static List<Integer> generate(){
        List<Integer> numberPool =  Arrays.asList(1,2,3,4,5,6,7,8,9);
        Collections.shuffle(numberPool);
        return numberPool.subList(0, 3);
    }

}
