
import domain.BaseballType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;



class BaseBallClientTest {

    private static int strike;
    private static int input;
    private static boolean isGame;
    private static Map<String,Integer> map;

    @BeforeEach
    public void setUp(){
      strike = 3;
      input = 1;
      isGame = true;
      map = new HashMap<>();
      map.put(BaseballType.STRIKE.name(),1);
      map.put(BaseballType.BALL.name(),1);
    }
    //게임 종료 마지막 출력
    @DisplayName("input 1이라면 false 대입, input 2라면 true 유지.")
    @Test
    void lastPrint(){
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작 하려면 1, 종료 하려면 2를 입력하세요.");
        }
        if(input == 1){
            isGame = false;
        }
        assertThat(isGame).isFalse();
    }

    //결과 출력 처리.
    @DisplayName("특정 카운트에 따라, 출력문 분기 처리.")
    @Test
    void resultPrint(){
        //둘다 값이 1일때의 가정.
        boolean isCheck = false;
        if(map.get(BaseballType.STRIKE.name()) > 0 && map.get(BaseballType.BALL.name()) > 0){
            System.out.println(map.get(BaseballType.STRIKE.name()) + BaseballType.STRIKE.getType() + map.get(BaseballType.BALL.name()) + BaseballType.BALL.getType());
            isCheck = true;
        }
        if(map.get(BaseballType.STRIKE.name()) > 0 && map.get(BaseballType.BALL.name()) == 0){
            System.out.println(map.get(BaseballType.STRIKE.name()) + BaseballType.STRIKE.getType());
        }
        if(map.get(BaseballType.STRIKE.name()) == 0 && map.get(BaseballType.BALL.name()) > 0){
            System.out.println(map.get(BaseballType.BALL.name()) + BaseballType.BALL.getType());
        }

        assertThat(isCheck).isTrue();

    }
}