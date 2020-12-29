import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountCheckerTest {

    CountChecker countChecker = new CountChecker(123);

    @DisplayName("생성 테스트")
    @Test
    void countCheckerGeneratorTest() {
        CountChecker tempCountChecker = new CountChecker(123);

        assertEquals("123", tempCountChecker.getAnswer());
        assertEquals(0, tempCountChecker.getStrikeCnt());
        assertEquals(0, tempCountChecker.getBallCnt());
    }

    @DisplayName("init 메소드는 strikeCnt, ballCnt를 0으로 초기화한다.")
    @Test
    void countCheckerInitTest() {
        countChecker.init();
        assertEquals(0, countChecker.getStrikeCnt());
        assertEquals(0, countChecker.getBallCnt());
    }

    @DisplayName("check 메소드 테스트, 입력 숫자에서 strike, ball을 카운트한다.")
    @Test
    void countCheckerCheckTest() {
        countChecker.check(456);
        assertEquals(0, countChecker.getStrikeCnt());
        assertEquals(0, countChecker.getBallCnt());

        countChecker.init();
        countChecker.check(123);
        assertEquals(3, countChecker.getStrikeCnt());
        assertEquals(0, countChecker.getBallCnt());

        countChecker.init();
        countChecker.check(132);
        assertEquals(1, countChecker.getStrikeCnt());
        assertEquals(2, countChecker.getBallCnt());
    }
}
