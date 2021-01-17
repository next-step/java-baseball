import com.main.baseball.dhsimpson.Baseball;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Test {

    @BeforeAll
    static void beforeAll() {
        System.out.println("===테스트 시작===");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("===테스트 종===");
    }

//    @org.junit.jupiter.api.Test
//    public void baseballGameTest() {
//        Baseball playGame = new Baseball();
//        playGame.playGame();
//    }

    // Ball 갯수 check 하는 unit Test
    @org.junit.jupiter.api.Test
    public void testCheckBall() {
        assertTrue(true);
        Baseball playGame = new Baseball();
        int[] pNum = {1,2,3};
        int[] cNum = {3,2,1};
        int idx = 1; // strike인 위치. 이 위치를 건너 뛰고 ball을 센다.
        int answer = 2; //위의 경우는 2볼

        assertSame(playGame.checkBall(pNum, cNum, idx), answer);
    }
}
