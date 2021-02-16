import baseball.domain.Baseball;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Test {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("===테스트 시작===");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("===테스트 종===");
    }

    // Ball 갯수 check 하는 unit Test
    @org.junit.jupiter.api.Test
    public void testCompareNums() {
        Baseball playGame = new Baseball();
        int[] pNum = {1,2,3};
        int[] cNum = {3,1,1};
        int idx = 0; // strike가 아닌 위치. 이 위치를 건너 뛰고 ball을 센다.
        boolean answer = false;
        assertSame(playGame.compareNums(pNum, cNum), answer);
    }

    // Ball 갯수 check 하는 unit Test
    @org.junit.jupiter.api.Test
    public void testCheckBall() {
        Baseball playGame = new Baseball();
        int[] pNum = {1,2,3};
        int[] cNum = {3,1,1};
        int idx = 0; // strike가 아닌 위치. 이 위치를 건너 뛰고 ball을 센다.
        int answer = 2; //위의 경우는 2볼
        assertSame(playGame.checkBall(pNum, cNum, idx), answer);
    }
}
