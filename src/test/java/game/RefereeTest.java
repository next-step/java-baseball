package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.io.PrintStream;

class RefereeTest {

    public PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);

    @BeforeEach
    void set_mocked_print_stream() {
        System.setOut(mockedPrintStream);
    }

    @DisplayName("3개의 숫자를 모두 맞히셨습니다! 게임 종료 결과가 잘 출력되는지 테스트")
    @ParameterizedTest
    @CsvSource({"123,123", "345,345", "678,678"})
    void three_strike_test(String pitcherBalls, String hitterBalls) {
        Pitcher pitcher = new Pitcher(pitcherBalls);
        Hitter hitter = new Hitter(hitterBalls);

        Referee referee = new Referee();
        GameResult gameResult = referee.getGameResult(pitcher, hitter);
        gameResult.printGameResult();
        Mockito.verify(mockedPrintStream).println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @DisplayName("2 스트라이크 결과가 잘 출력되는지 테스트")
    @ParameterizedTest
    @CsvSource({"124,123", "346,345", "679,678"})
    void two_strike_test(String pitcherBalls, String hitterBalls) {
        Pitcher pitcher = new Pitcher(pitcherBalls);
        Hitter hitter = new Hitter(hitterBalls);

        Referee referee = new Referee();
        GameResult gameResult = referee.getGameResult(pitcher, hitter);
        gameResult.printGameResult();
        Mockito.verify(mockedPrintStream).print("2 스트라이크 ");
    }

    @DisplayName("1 스트라이크 2 볼 결과가 잘 출력되는지 테스트")
    @ParameterizedTest
    @CsvSource({"132,123", "354,345", "687,678"})
    void one_strike_two_ball_test(String pitcherBalls, String hitterBalls) {
        Pitcher pitcher = new Pitcher(pitcherBalls);
        Hitter hitter = new Hitter(hitterBalls);

        Referee referee = new Referee();
        GameResult gameResult = referee.getGameResult(pitcher, hitter);
        gameResult.printGameResult();
        Mockito.verify(mockedPrintStream).print("1 스트라이크 ");
        Mockito.verify(mockedPrintStream).print("2 볼");
    }

    @DisplayName("낫싱 결과가 잘 출력되는지 테스트")
    @ParameterizedTest
    @CsvSource({"456,123", "789,345", "123,678"})
    void nothing_test(String pitcherBalls, String hitterBalls) {
        Pitcher pitcher = new Pitcher(pitcherBalls);
        Hitter hitter = new Hitter(hitterBalls);

        Referee referee = new Referee();
        GameResult gameResult = referee.getGameResult(pitcher, hitter);
        gameResult.printGameResult();
        Mockito.verify(mockedPrintStream).println("낫싱");
    }
}
