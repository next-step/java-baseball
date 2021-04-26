package game.baseball;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originOut = System.out;
    private static Baseball baseball;

    @BeforeAll
    public static void initial() {
        baseball = new Baseball();
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originOut);
    }


    @DisplayName("컴퓨터 숫자가 3자리 인지 확인")
    @Test
    public void valid_computer_numbers_length() {
        assertEquals(baseball.computerNumbers.length, BaseballConstants.BASEBALL_COUNT);
    }

    @DisplayName("컴퓨터 숫자가 서로 다른 수 인지 확인")
    @Test
    public void valid_computer_numbers_unique() {
        boolean isUnique = true;
        for (int i = 0; i < baseball.computerNumbers.length - 1; i++) {
            if (baseball.computerNumbers[i] == baseball.computerNumbers[i + 1]) {
                isUnique = false;
                break;
            }
        }
        assertTrue(isUnique);
    }

    @DisplayName("각 자리 수가 한자리 숫자인지 확인")
    @Test
    public void valid_player_numbers_under_10() {
        boolean isUnder10 = true;
        baseball.makePlayerNumbers(456);
        for (int i = 0; i < baseball.playerNumbers.length; i++) {
            if (baseball.playerNumbers[i] >= 10) {
                isUnder10 = false;
            }
        }
        assertTrue(isUnder10);
    }

    @DisplayName("strike & ball 판단")
    @Test
    public void check_strike_and_ball_count() {
        for (int i = 0; i < baseball.computerNumbers.length; i++) {
            baseball.playerNumbers[i] = baseball.computerNumbers[i];
        }

        baseball.checkStrikeAndBallCount();

        assertEquals(baseball.strikeCount, BaseballConstants.BASEBALL_COUNT);
        assertEquals(baseball.ballCount, 0);

        for (int i = 0; i < baseball.computerNumbers.length; i++) {
            if (i == 0) {
                baseball.playerNumbers[i] = baseball.computerNumbers[baseball.computerNumbers.length - 1];
            } else {
                baseball.playerNumbers[i] = baseball.computerNumbers[i - 1];
            }
        }

        baseball.checkStrikeAndBallCount();

        assertEquals(baseball.ballCount, BaseballConstants.BASEBALL_COUNT);
        assertEquals(baseball.strikeCount, 0);
    }

    @DisplayName("3 strike 판단")
    @Test
    public void is_3_strike() {
        baseball.strikeCount = 2;
        assertTrue(baseball.isNotThreeStrike());
    }

    @DisplayName("게임 결과 출력 - 낫싱")
    @Test
    public void print_game_result_nothing() {
        baseball.strikeCount = 0;
        baseball.ballCount = 0;
        baseball.printGameResult();
        assertEquals("낫싱\r\n", outContent.toString());
    }

    @DisplayName("게임 결과 출력 - 1스트라이크 2볼")
    @Test
    public void print_game_result_1strike_2ball() {
        baseball.strikeCount = 1;
        baseball.ballCount = 2;
        baseball.printGameResult();
        assertEquals("1 스트라이크 2 볼\r\n", outContent.toString());
    }

    @DisplayName("게임 결과 출력 - 게임 종료")
    @Test
    public void print_game_result_3strike() {
        baseball.strikeCount = 3;
        baseball.ballCount = 0;
        baseball.printGameResult();
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n", outContent.toString());
    }
}
