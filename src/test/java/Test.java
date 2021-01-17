import com.main.baseball.dhsimpson.Baseball;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Test {

    @BeforeAll
    static void beforeAll() {
        System.out.println("===테스트 시작===");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("===테스트 종료===");
    }

    @org.junit.jupiter.api.Test
    public void baseballGameTest() {
        new Baseball();
    }
}
