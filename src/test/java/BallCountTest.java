import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallCountTest {

    @DisplayName("볼 카운트가 제대로 출력되는지 확인")
    @Test
    public void testToString(){
        BallCount ballCount=new BallCount(1,2);
        assertEquals("1 스트라이크 2 볼",ballCount.toString());
        ballCount=new BallCount(2,1);
        assertEquals("2 스트라이크 1 볼",ballCount.toString());
        ballCount=new BallCount(3,0);
        assertEquals("3 스트라이크 ",ballCount.toString());
        ballCount=new BallCount(0,0);
        assertEquals("낫싱",ballCount.toString());
        ballCount=new BallCount(1,0);
        assertEquals("1 스트라이크 ",ballCount.toString());
        ballCount=new BallCount(2,0);
        assertEquals("2 스트라이크 ",ballCount.toString());
        ballCount=new BallCount(3,0);
        assertEquals("3 스트라이크 ",ballCount.toString());
        ballCount=new BallCount(0,3);
        assertEquals("3 볼",ballCount.toString());
    }




}
