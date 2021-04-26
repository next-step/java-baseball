import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.*;
import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {
    BaseballGame baseballGame;
    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @DisplayName("랜덤숫자 생성 확인")
    @Test
    void createRandomNumber() {
        List<Integer> randomNumber1 = baseballGame.createRandomNumber();

        assertThat(randomNumber1).isNotEmpty()
                .doesNotContainNull()
                .hasSize(3);
    }

    @DisplayName("사용자 입력값 확인")
    @ParameterizedTest
    @CsvSource({"0, false", "123, true", "24, false", "'',false"})
    void validateUserNumber(String input, boolean expected) {
        boolean result = baseballGame.validateUserNumber(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사용자 입력값을 List<Integer> 변환 확인")
    @ParameterizedTest
    @CsvSource({"342,3,4,2", "436,4,3,6", "528,5,2,8"})
    void toIntegerList(String userNumber, int a, int b, int c) {
        List<Integer> number = baseballGame.toIntegerList(userNumber);
        assertThat(number).isNotEmpty()
                .doesNotContainNull()
                .containsSequence(a,b,c);
    }

    @DisplayName("null 값 List<Integer> 변환시 예외 확인")
    @Test
    void exception_toIntegerList() {
        String input = "";
        assertThatThrownBy(() -> {
            List<Integer> number = baseballGame.toIntegerList(input);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 0");
    }

    @DisplayName("게임 결과 확인")
    @ParameterizedTest
    @CsvSource({"436,987,낫싱", "436,463,1 스트라이크 2 볼", "528,528,3 스트라이크"})
    void calculateResult(String randomNumber, String userNumber, String result) {
        List<Integer> random = baseballGame.toIntegerList(randomNumber);
        List<Integer> user = baseballGame.toIntegerList(userNumber);

        BaseballResult baseballResult = baseballGame.calculateResult(random, user);
        assertThat(baseballResult.toString()).isEqualTo(result);
    }

    @DisplayName("스트라이크 판별 함수 확인")
    @ParameterizedTest
    @CsvSource({"1,1,1", "1,9,0", "3,2,0"})
    void checkStrike(int randomNumber, int userNumber, int result) {
        int resultStrike = baseballGame.checkStrike(randomNumber,userNumber);
        assertThat(resultStrike).isEqualTo(result);
    }

    @DisplayName("볼 판별 함수 확인")
    @ParameterizedTest
    @CsvSource({"1,132,1,1", "1,254,2,0", "3,223,0,1"})
    void checkBall(int randomNumber, String userNumber, int index, int result) {
        int resultBall = baseballGame.checkBall(randomNumber, baseballGame.toIntegerList(userNumber), index);
        assertThat(resultBall).isEqualTo(result);
    }

    @DisplayName("결과 문구 출력 확인")
    @ParameterizedTest
    @CsvSource({"0,0,낫싱", "3,3,3 스트라이크", "2,1,2 스트라이크 1 볼"})
    void printResult(int strike, int ball, String result) {
        BaseballResult baseballResult = new BaseballResult(strike, ball);
        assertThat(baseballResult.toString()).isEqualTo(result);
    }
    
    @DisplayName("결과 정답,오답 확인")
    @ParameterizedTest
    @CsvSource({"3,3,true", "2,1,false", "0,0,false"})
    void checkAnswer(int strike, int ball, boolean expected) {
        BaseballResult baseballResult = new BaseballResult(strike, ball);
        boolean result = baseballGame.checkAnswer(baseballResult);
        assertThat(result).isEqualTo(expected);
    }
}