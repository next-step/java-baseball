import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BallCount 테스트")
class BallCountTest {

    private static Numbers answerNumbers;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeAll
    static void beforeAll() {
        answerNumbers = new Numbers(List.of(7, 1, 3));
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("볼과 스트라이크 모두 있는 경우")
    @Test
    void ballsAndStrikesTest() {
        // given
        Numbers playerNumbers = new Numbers(List.of(1, 2, 3));

        // when
        BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
        ballCount.printDetailedCountMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("볼만 있는 경우")
    @Test
    void onlyBallsTest() {
        // given
        Numbers playerNumbers = new Numbers(List.of(6, 7, 1));

        // when
        BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
        ballCount.printDetailedCountMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼");
    }

    @DisplayName("스트라이크만 있는 경우")
    @Test
    void onlyStrikesTest() {
        // given
        Numbers playerNumbers = new Numbers(List.of(2, 1, 6));

        // when
        BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
        ballCount.printDetailedCountMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1스트라이크");
    }

    @DisplayName("'낫싱'인 경우")
    @Test
    void nothingTest() {
        // given
        Numbers playerNumbers = new Numbers(List.of(2, 8, 5));

        // when
        BallCount ballCount = new BallCount(answerNumbers, playerNumbers);
        ballCount.printDetailedCountMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("낫싱");
    }
}